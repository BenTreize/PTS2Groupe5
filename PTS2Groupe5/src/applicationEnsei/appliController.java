package applicationEnsei;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.UIManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class appliController {
	@FXML
	private Label pathVideo;
	@FXML
	private Label pathEnre;
	@FXML
	private TextField name;
	@FXML
	private CheckBox casse;
	@FXML
	private RadioButton modeEnt;
	@FXML
	private ToggleGroup ModeGrp;
	@FXML
	private CheckBox incomplet;
	@FXML
	private TextField nbincomplet;
	@FXML
	private CheckBox nbdecouvert;
	@FXML
	private CheckBox solution;
	@FXML
	private RadioButton modeEva;
	@FXML
	private CheckBox tps;
	@FXML
	private TextField nbtps;
	@FXML
	private TextArea consigne;
	@FXML
	private TextArea aide;
	@FXML
	private TextArea texte;
	@FXML
	private Label txtnbtps;
	@FXML
	private Label txtnbincomplet;
	
	public void choixVideoBtn(ActionEvent event) {

		String tempPath = select();

		if (!tempPath.equals("")) {
			pathVideo.setText(tempPath);
		}

	}
	
	public void choixEnre(ActionEvent event) {

		String tempPath = selectDir();

		if (!tempPath.equals("")) {
			pathEnre.setText(tempPath);
		}

	}
	
	public void help(ActionEvent aide) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("help.fxml"));
		Stage helpWindow = new Stage();

		helpWindow.setScene(new Scene(root));
		helpWindow.show();

		// Logo et nom
		helpWindow.setTitle("Aide - Version enseignante");
		helpWindow.getIcons().add(new Image(getClass().getResourceAsStream("logoappens.png")));
		// Pas de changement de taille
		helpWindow.setFullScreen(false);
		helpWindow.setMaximized(false);
		helpWindow.setResizable(false);

	}
	
	public void propos(ActionEvent aide) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("propos.fxml"));
		Stage helpWindow = new Stage();

		helpWindow.setScene(new Scene(root));
		helpWindow.show();

		// Logo et nom
		helpWindow.setTitle("À propos - Version enseignante");
		helpWindow.getIcons().add(new Image(getClass().getResourceAsStream("logoappens.png")));
		// Pas de changement de taille
		helpWindow.setFullScreen(false);
		helpWindow.setMaximized(false);
		helpWindow.setResizable(false);

	}
	
	public static String select() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO faire l'exception
		}

		JFileChooser dialogue = new JFileChooser(new File("."));
		File fichier;
		Path local;

		if (dialogue.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { // Ouvre un selecteur de fichier
			fichier = dialogue.getSelectedFile();
			local = fichier.toPath();
		}
		// TODO
		else
			return "";
		// TODO

		String localFinal = local.toString();
		return localFinal;

	}
	
	public static String selectDir() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO faire l'exception
		}

		JFileChooser dialogue = new JFileChooser(new File("."));
		dialogue.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // uniquement des dossiers
		File fichier;
		Path local;

		if (dialogue.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { // Ouvre un selecteur de fichier
			fichier = dialogue.getSelectedFile();
			local = fichier.toPath();
		}
		// TODO
		else
			return "";
		// TODO

		String localFinal = local.toString();
		return localFinal;

	}
	public void modeEnt(ActionEvent event) {
		tps.setDisable(true);
		nbtps.setDisable(true);
		txtnbtps.setDisable(true);
		incomplet.setDisable(false);
		nbincomplet.setDisable(false);
		txtnbincomplet.setDisable(false);
		nbdecouvert.setDisable(false);
		solution.setDisable(false);		
	}
	
	public void modeEva(ActionEvent event) {
		tps.setDisable(false);
		nbtps.setDisable(false);
		txtnbtps.setDisable(false);
		incomplet.setDisable(true);
		nbincomplet.setDisable(true);
		txtnbincomplet.setDisable(true);
		nbdecouvert.setDisable(true);
		solution.setDisable(true);		
	}
}
