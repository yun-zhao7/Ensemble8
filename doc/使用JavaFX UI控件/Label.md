# 创建标签

​		JavaFX API提供了Label用于在应用程序中创建标签的类的三个构造函数

```java
// 一个空标签
Label label1 = new Label();
// 带有文本元素
Label label2 = new Label("Search");
// 带有文本元素和图形图标的标签
Image image = new Image(getClass().getResourceAsStream("labels.jpg"));
Label label3 = new Label("Search", new ImageView(image));
```

​		在代码中创建标签后，可以使用以下`Labeled`类的方法向其中添加文本和图形内容。

- 该`setText(String text)`方法-指定标签文本标题

- `setGraphic(Node graphic)`–指定图形图标

   创建一个文本标签，向其添加一个图标，并为文本指定填充颜色。 

```java
Label label1 = new Label("Search");
Image image = new Image(getClass().getResourceAsStream("labels.jpg"));
// setTextFill方法指定用于绘制标签文本元素的颜色
label1.setGraphic(new ImageView(image));
label1.setTextFill(Color.web("#0076a3"));
```

 		在为按钮定义文本和图形内容时，可以使用该`setGraphicTextGap`方法设置它们之间的间隔。可以使用`setTextAlignment`方法在其布局区域内更改标签内容的位置。还可以通过施加限定的图形相对于所述文本的位置`setContentDisplay`的方法和指定以下之一`ContentDisplay`常数：`LFFT`，`RIGHT`，`CENTER`，`TOP`，`BOTTOM`。 

# 设置字体

 		要提供标签默认字体以外的字体文本大小，请使用类的`setFont`方法`Labeled`。将label1文本的大小设置为30点，字体名称设置为Arial。对于label2，将文本大小设置为32磅，字体名称设置为Cambria。 

```java
label1.setFont(new Font("Arial", 30));
label2.setFont(Font.font("Cambria", 32));
```

# 包装文字

 		创建标签时，有时必须将其放置在小于渲染所需的空间内。要分解（包装）文本使其适合布局区域，请设置方法的`true`值`setWrapText` 

```java
Label label3 = new Label("A label that needs to be wrapped");
label3.setWrapText(true);
```

 		假设标签的布局区域不仅受到其宽度的限制，还受到其高度的限制。当无法呈现整个所需的文本字符串时，可以指定标签的行为。使用类的`setTextOverrun`方法`Labeled`和可用的`OverrunStyle`类型之一来定义如何处理文本字符串中无法正确呈现的部分。 

# 应用效果

​		 尽管标签是静态内容，无法编辑，但是您可以对其应用视觉效果或变换。  将label2旋转了270度，并垂直转换了其位置。 

```java
Label label2 = new Label ("Values");
label2.setFont(new Font("Cambria", 32));
label2.setRotate(270);
label2.setTranslateY(50);
```

 		旋转和平移是JavaFX API中可用的典型转换。此外，您可以设置一种效果，当用户将鼠标指针悬停在标签上时，该标签会放大（放大）标签。  将缩放效果应用于label3。在`MOUSE_ENTERED`标签上触发事件后，将为`setScaleX`和`setScaleY`方法设置比例因子1.5 。当用户将鼠标光标移离标签并`MOUSE_EXITED`发生事件时，比例因子设置为1.0，并且标签以其原始大小呈现。 

```java
label3.setOnMouseEntered((MouseEvent e) -> {
    label3.setScaleX(1.5);
    label3.setScaleY(1.5);
});

label3.setOnMouseExited((MouseEvent e) -> {
    label3.setScaleX(1);
    label3.setScaleY(1);
});
```

