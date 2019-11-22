package ensemble.app;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.scene.Node;

/**
 * Interface for all pages
 */
public interface Page {
    public ReadOnlyStringProperty titleProperty();
    public String getTitle();
    public String getUrl();
    public Node getNode();
}
