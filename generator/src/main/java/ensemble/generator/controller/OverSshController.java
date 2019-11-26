package ensemble.generator.controller;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import ensemble.generator.model.DatabaseConfig;
import ensemble.generator.util.ConfigHelper;
import ensemble.generator.util.DbUtil;
import ensemble.generator.view.AlertUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import org.apache.commons.lang3.StringUtils;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.*;

/**
 * @author chenzejin
 * @date 2019/11/26
 */
public class OverSshController extends DbConnectionController {

    @FXML
    public Label lPortLabel;
    @FXML
    public TextField sshUserField;
    @FXML
    public PasswordField sshPasswordField;
    @FXML
    private TextField sshHostField;
    @FXML
    private TextField sshdPortField;
    @FXML
    private TextField lportField;
    @FXML
    private TextField rportField;
    @FXML
    private Label note;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setDbConnectionConfig(DatabaseConfig databaseConfig) {
        if (databaseConfig == null) {
            return;
        }
        isUpdate = true;
        super.setConfig(databaseConfig);
        this.sshdPortField.setText(databaseConfig.getSshPort());
        this.sshHostField.setText(databaseConfig.getSshHost());
        this.lportField.setText(databaseConfig.getLport());
        this.rportField.setText(databaseConfig.getRport());
        this.sshUserField.setText(databaseConfig.getSshUser());
        this.sshPasswordField.setText(databaseConfig.getSshPassword());
        //例如：默认从本机的 3306 -> 转发到 3306
        if (StringUtils.isBlank(this.lportField.getText())) {
            this.lportField.setText(databaseConfig.getPort());
        }
        if (StringUtils.isBlank(this.rportField.getText())) {
            this.rportField.setText(databaseConfig.getPort());
        }
        checkInput();
    }

    @FXML
    public void checkInput() {
        DatabaseConfig databaseConfig = extractConfigFromUi();
        if (StringUtils.isBlank(databaseConfig.getSshHost())
                || StringUtils.isBlank(databaseConfig.getSshPort())
                || StringUtils.isBlank(databaseConfig.getSshUser())
                || StringUtils.isBlank(databaseConfig.getSshPassword())
        ) {
            note.setText("当前SSH配置输入不完整，OVER SSH不生效");
            note.setTextFill(Paint.valueOf("#ff666f"));
        } else {
            note.setText("当前SSH配置生效");
            note.setTextFill(Paint.valueOf("#5da355"));
        }
    }

    public void setLPortLabelText(String text) {
        lPortLabel.setText(text);
    }

    public void recoverNotice() {
        this.lPortLabel.setText("注意不要填写被其他程序占用的端口");
    }

    public DatabaseConfig extractConfigFromUi() {
        String name = nameField.getText();
        String host = hostField.getText();
        String port = portField.getText();
        String userName = userNameField.getText();
        String password = passwordField.getText();
        String encoding = encodingChoice.getValue();
        String dbType = dbTypeChoice.getValue();
        String schema = schemaField.getText();
        DatabaseConfig config = new DatabaseConfig();
        config.setName(name);
        config.setDbType(dbType);
        config.setHost(host);
        config.setPort(port);
        config.setUsername(userName);
        config.setPassword(password);
        config.setSchema(schema);
        config.setEncoding(encoding);
        config.setSshHost(this.sshHostField.getText());
        config.setSshPort(this.sshdPortField.getText());
        config.setLport(this.lportField.getText());
        config.setRport(this.rportField.getText());
        config.setSshUser(this.sshUserField.getText());
        config.setSshPassword(this.sshPasswordField.getText());
        return config;
    }

    public void saveConfig() {
        DatabaseConfig databaseConfig = extractConfigFromUi();
        if (StringUtils.isAnyEmpty(
                databaseConfig.getName(),
                databaseConfig.getHost(),
                databaseConfig.getPort(),
                databaseConfig.getUsername(),
                databaseConfig.getEncoding(),
                databaseConfig.getDbType(),
                databaseConfig.getSchema())) {
            AlertUtil.showWarnAlert("密码以外其他字段必填");
            return;
        }
        try {
            ConfigHelper.saveDatabaseConfig(this.isUpdate, primayKey, databaseConfig);
            getDialogStage().close();
            mainUIController.loadLeftDBTree();
        } catch (Exception e) {
            AlertUtil.showErrorAlert(e.getMessage());
        }
    }

    @FXML
    public void testSSH() {
        Session session = DbUtil.getSSHSession(extractConfigFromUi());
        if (session == null) {
            AlertUtil.showErrorAlert("请检查主机，端口，用户名，以及密码是否填写正确");
            return;
        }
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> result = executorService.submit(() -> {
            try {
                session.connect();
            } catch (JSchException e) {
                throw new RuntimeException(e.getMessage());
            }
        });
        executorService.shutdown();
        try {
            boolean b = executorService.awaitTermination(5, TimeUnit.SECONDS);
            if (!b) {
                throw new TimeoutException("连接超时");
            }
            result.get();
            AlertUtil.showInfoAlert("连接SSH服务器成功，恭喜你可以使用OverSSH功能");
            recoverNotice();
        } catch (Exception e) {
            AlertUtil.showErrorAlert("请检查主机，端口，用户名，以及密码是否填写正确: " + e.getMessage());
        } finally {
            DbUtil.shutdownPortForwarding(session);
        }
    }

    @FXML
    public void reset(ActionEvent actionEvent) {
        this.sshUserField.clear();
        this.sshPasswordField.clear();
        this.sshdPortField.clear();
        this.sshHostField.clear();
        this.lportField.clear();
        this.rportField.clear();
        recoverNotice();
    }

}
