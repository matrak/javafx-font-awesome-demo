package ninja.devlabs.jfx.demos.fa;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.layout.HBox;

public class AppController implements Initializable {
    
    @FXML
    private HBox iconContainer;
    
    @FXML 
    private Label icon;
    
    @FXML
    private ChoiceBox<String> selectIcon;
    
    @FXML
    private Button buttonLeft, buttonRight;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {               
        iconContainer.setAlignment(Pos.CENTER);
        
        Set<String> faKeys = resources.keySet();
        ObservableList<String> faKeysObservable = FXCollections.observableArrayList(faKeys);
        selectIcon.setItems(faKeysObservable);        
        selectIcon.getSelectionModel().selectFirst();        
        selectIcon.getSelectionModel().selectedItemProperty().addListener((
                ObservableValue<? extends String> observable, 
                String oldValue, 
                String newValue) -> {
            
            icon.setText(resources.getString(newValue));
        });
        
        final ObjectProperty<SingleSelectionModel<String>> selectionModel = selectIcon.selectionModelProperty();
        
        icon.setText(resources.getString(selectionModel.getValue().getSelectedItem()));
        
        buttonLeft.setOnMouseClicked(event -> {
            int index = selectionModel.getValue().getSelectedIndex();
            index = (index > 0) ? (index - 1) : (faKeys.size() - 1);
            selectionModel.getValue().select(index);
    	});
        
        buttonRight.setOnMouseClicked(event -> {
            int index = selectionModel.getValue().getSelectedIndex();
            index = (index + 1) % faKeys.size();
            selectionModel.getValue().select(index);
    	});
        
    }
}
