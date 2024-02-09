
package finalproject;

import java.net.MalformedURLException;
import java.net.URL;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import org.json.JSONObject;

public class MovieCard extends HBox {

    private ImageView posterImageView;
    private Label titleLabel;
    private Label overviewLabel;
    private Label releaseDateLabel;
    private Button favorite;

    public MovieCard(JSONObject jsonObject) {
        // Initialize UI components
        posterImageView = new ImageView();
        posterImageView.setFitWidth(150); // Set the desired width
        posterImageView.setPreserveRatio(true);

        titleLabel = new Label();
        overviewLabel = new Label();
        releaseDateLabel = new Label();
        favorite = new Button("fav");

        // Create a vertical box to hold labels
        VBox labelsVBox = new VBox(posterImageView,titleLabel, overviewLabel, releaseDateLabel,favorite);
        labelsVBox.setSpacing(1);
        

        // Create an HBox to hold the poster image and labels
//        HBox contentHBox = new HBox( labelsVBox, favorite);
//        contentHBox.setSpacing(5);
        

        // Set padding for the entire movie card
        setPadding(new Insets(5));
        setSpacing(5);

        // Add UI components to the movie card
        getChildren().add(labelsVBox);
    }

    public void setMovieData(String title, String overview, String releaseDate, String posterPath) {
        // Set data to UI components
        titleLabel.setText("Title: " + title);
//        overviewLabel.setText("Overview: " + overview);
        releaseDateLabel.setText("Release Date: " + releaseDate);

        // Set text color for labels
        titleLabel.setTextFill(Color.WHITE); // Set your desired color
        overviewLabel.setTextFill(Color.WHITE); // Set your desired color
        releaseDateLabel.setTextFill(Color.WHITE); // Set your desired color

        try {
            // Load and set the poster image
            Image posterImage = new Image(new URL("https://image.tmdb.org/t/p/w500" + posterPath).toExternalForm());
            posterImageView.setImage(posterImage);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    // You can add getter methods for CheckBox and other components if needed
    public Button getFavoriteButton (){
        return favorite;
    }
}

