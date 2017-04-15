package nl.mierasmade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

import com.jfoenix.controls.JFXDecorator;

import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.container.DefaultFlowContainer;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.mierasmade.fakers.Fakers;
import nl.mierasmade.main.MainController;
import nl.mierasmade.writer.DataWriter;


@Lazy
@SpringBootApplication
public class GuiApplication extends GuiApplicationSupport {
	
	@FXMLViewFlowContext 
	private ViewFlowContext applicationContext;
	@Autowired
	private Fakers fakers;
	@Autowired
	private DataWriter dataWriter;
	
	public static void main(String[] args) {
		launchApp(GuiApplication.class, args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {		
		Flow flow = new Flow(MainController.class);
		DefaultFlowContainer container = new DefaultFlowContainer();
		
		applicationContext = new ViewFlowContext();					
		applicationContext.register("primaryStage", primaryStage);		
		applicationContext.register("fakers", fakers);		
		applicationContext.register("dataWriter", dataWriter);		
		flow.createHandler(applicationContext).start(container);
		
		JFXDecorator decorator = new JFXDecorator(primaryStage, container.getView());
		decorator.setCustomMaximize(true);
		Scene scene = new Scene(decorator, 1280, 900);
		scene.getStylesheets().add("css/jfoenix-components.css");
		scene.getStylesheets().add("css/jfoenix-main.css");
		primaryStage.setMinWidth(650);
		primaryStage.setMinHeight(800);
		primaryStage.setScene(scene);
		primaryStage.show();		
	}
}