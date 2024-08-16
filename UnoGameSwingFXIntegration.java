import javax.swing.*;
import java.awt.*;
import javafx.embed.swing.JFXPanel;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class UnoGameSwingFXIntegration extends JFrame {
    private JFXPanel fxPanel;

    public UnoGameSwingFXIntegration() {
        setTitle("UNO Game with Swing and JavaFX");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());  

        fxPanel = new JFXPanel();
        add(fxPanel, BorderLayout.CENTER);

        Platform.runLater(() -> {
            VBox root = new VBox(new Label("JavaFX Component"));
            Scene scene = new Scene(root, 300, 200);
            fxPanel.setScene(scene);
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UnoGameSwingFXIntegration());
    }
}
