/**
 * @author Jerry Shen
 * Images used are either taken by Jerry Shen or are free creative commons images
 */

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {

	//starting location; int used as a counter, str serves as direction (N,E,S,W)
	private String loc = "1 N";
	
	@FXML
	private ImageView worldView;
	@FXML
	private ImageView itemView1;
	@FXML
	private ImageView itemView2;
	
	@FXML
	private Polygon forward;
	@FXML
	private Polygon back;
	@FXML
	private Polygon rotateRight;
	@FXML
	private Polygon rotateLeft;
	
	@FXML 
	private TextArea textArea;
	
	@FXML
	private ImageView inventory1;
	@FXML
	private ImageView inventory2;
	
	//initializing the images & items
	private Image one = new Image("01.jpg");
	private Image two = new Image("02.jpg");
	private Image three = new Image("03.jpg");
	private Image four = new Image("04.jpg");
	private Image five = new Image("05.jpg");
	private Image six = new Image("06.jpg");
	private Image seven = new Image("07.jpg");
	private Image eight = new Image("08.jpg");
	private Image eight_five = new Image("08-5.jpg");
	private Image nine = new Image("09.jpg");
	private Image ten = new Image("10.jpg");
	private Image eleven = new Image("11.jpg");
	private Image twelve = new Image("12.jpg");
	private Image thirteen = new Image("13.jpg");
	private Image fourteen = new Image("14.jpg");
	private Image fifteen = new Image("15.jpg");
	private Image sixteen = new Image("16.jpg");
	private Image seventeen = new Image("17.jpg");
	private Image eighteen = new Image("18.jpg");
	private Image nineteen = new Image("19.jpg");
	private Image twenty = new Image("20.jpg");
	private Image twenty_one = new Image("21.jpg");
	private Image twenty_two = new Image("22.jpg");
	private Image twenty_three = new Image("23.jpg");
	private Image twenty_four = new Image("24.jpg");
	private Image twenty_five = new Image("25.jpg");
	private Image twenty_six = new Image("26.jpg");
	private Image twenty_seven = new Image("27.jpg");
	private Image twenty_eight = new Image("28.jpg");
	private Image twenty_nine = new Image("29.jpg");
	private Image thirty = new Image("30.jpg");
	private Image thirty_one = new Image("31.jpg");
	private Image thirty_two = new Image("32.jpg");
	private Image thirty_three = new Image("33.jpg");
	private Image thirty_four = new Image("34.jpg");
	private Image thirty_five = new Image("35.jpg");
	private Image thirty_six = new Image("36.jpg");
	private Image thirty_seven = new Image("37.jpg");
	private Image thirty_eight = new Image("38.jpg");
	
	private Image item1 = new Image("item1.png");
	private Image item2 = new Image("item2.png");
	
	//initialize hashmaps to store all the world images & items
	Map<String, Image> images_map = new HashMap<String, Image>();
	Map<String, Image> items_map = new HashMap<String, Image>();
	Map<String, Image> inventory_map = new HashMap<String, Image>();
	
	//called from MainProgram.java
	//this method is just used to place everything into their respective maps
	//first int = position, str = direction, third int = item #
	public void Initialise() {
		items_map.put("4 W 1", item1);
		items_map.put("6 S 2", item2);
		
		images_map.put("1 N", one);
		images_map.put("2 N", two);
		images_map.put("3 N", three);
		images_map.put("4 N", four);
		images_map.put("4 W", five);
		images_map.put("4 E", six);
		images_map.put("5 E", seven);
		images_map.put("5 S", eight);
		images_map.put("6 S", eight_five);
		images_map.put("7 S", nine);
		images_map.put("7 E", ten);
		images_map.put("7 N", eleven);
		images_map.put("8 N", twelve);
		images_map.put("8 W", thirteen);
		images_map.put("9 W", fourteen);
		images_map.put("9 S", fifteen);
		images_map.put("10 S", sixteen);
		images_map.put("11 S", seventeen);
		images_map.put("12 S", eighteen);
		images_map.put("13 S", nineteen);
		images_map.put("13 W", twenty);
		images_map.put("14 W", twenty_one);
		images_map.put("14 N", twenty_two);
		images_map.put("15 N", twenty_three);
		images_map.put("16 N", twenty_four);
		images_map.put("16 E", twenty_five);
		images_map.put("17 E", twenty_six);
		images_map.put("17 S", twenty_seven);
		images_map.put("18 S", twenty_eight);
		images_map.put("19 S", twenty_nine);
		images_map.put("20 S", thirty);
		images_map.put("20 W", thirty_one);
		images_map.put("21 W", thirty_two);
		images_map.put("21 N", thirty_three);
		images_map.put("22 N", thirty_four);
		images_map.put("23 N", thirty_five);
		images_map.put("24 N", thirty_six);
		images_map.put("25 N", thirty_seven);
		images_map.put("25 E", thirty_eight);
		
		textArea.setEditable(false);
		//set the starting scene
		worldView.setImage(one);
	}
	
	//called when forward polygon arrow is clicked
	public void goForward() {
		//clear everything, then check then add items/inventory accordingly
		textArea.setText("");
		itemView1.setImage(null);
		itemView2.setImage(null);
		String[] temp_loc = loc.split("\\s+");
		
		//check if next location has things to add/remove
		try {
			int temp_int = Integer.parseInt(temp_loc[0]) + 1;
			String temp = Integer.toString(temp_int) + " " + temp_loc[1];
			Image temp_image = images_map.get(temp);
			
			//used to check if image exists, if not, then prevent blank scene
			if (temp_image==null) {
				textArea.setText("Not Allowed");
				showItems(loc);
				return; }
			worldView.setImage(temp_image);
			
			//updates loc to be used in future
			loc = temp;
			
			//displays the item if it's here
			showItems(temp);
		}
		catch (Exception e) {}
	}
	
	//called when back polygon arrow is clicked
	//very similar to goForward, comments from there can be applied here
	public void goBack() {
		textArea.setText("");
		itemView1.setImage(null);
		itemView2.setImage(null);
		String[] temp_loc = loc.split("\\s+");

		try {
			int temp_int = Integer.parseInt(temp_loc[0]) - 1;
			String temp = Integer.toString(temp_int) + " " + temp_loc[1];

			Image temp_image = images_map.get(temp);
			
			//used to check if image exists, if not, then prevent blank scene
			if (temp_image==null) {
				textArea.setText("Not Allowed");
				showItems(loc);
				return; }
			worldView.setImage(temp_image);
			
			//updates loc to be used in future
			loc = temp;
			
			//displays the item if it's here
			showItems(temp);
		}
		catch (Exception e) {}
	}
	
	//called when rotateRight polygon arrow is clicked
	//very similar to goForward, comments from there can be applied here
	public void rotateRight() {
		textArea.setText("");
		itemView1.setImage(null);
		itemView2.setImage(null);
		String[] temp_loc = loc.split("\\s+");
		try {
			String temp_dir = temp_loc[1];
			
			//after splitting the str, check the next direction
			String result = checkDirections(temp_dir, "R");
			String temp = temp_loc[0] + " " + result;
			Image temp_image = images_map.get(temp);
			
			//used to check if image exists, if not, then prevent blank scene
			if (temp_image==null) { 
				textArea.setText("Not Allowed");
				showItems(loc);
				return; }
			worldView.setImage(temp_image);
			
			//updates loc to be used in future
			loc = temp;
			
			//displays the item if it's here
			showItems(temp);
		}
		catch (Exception e) {}
	}
	
	//called when rotateLeft polygon arrow is clicked
	//very similar to goForward, comments from there can be applied here
	public void rotateLeft() {
		textArea.setText("");
		itemView1.setImage(null);
		itemView2.setImage(null);
		String[] temp_loc = loc.split("\\s+");
		try {
			String temp_dir = temp_loc[1];
			
			//after splitting the str, check the next direction
			String result = checkDirections(temp_dir, "L");
			String temp = temp_loc[0] + " " + result;
			Image temp_image = images_map.get(temp);
			
			//used to check if image exists, if not, then prevent blank scene
			if (temp_image==null) {
				textArea.setText("Not Allowed");
				showItems(loc); 
				return; }
			worldView.setImage(temp_image);
			
			//updates loc to be used in future
			loc = temp;
			showItems(temp);
		}
		catch (Exception e) {}
	}
	
	//dir: current facing direction (N/E/S/W)
	//rot: what rotation to make (right/left)
	//Makes sure the correct direction is returned
	public String checkDirections(String dir, String rot) {
		if (dir.equals("N") && rot.equals("R")) { return "E";}
		else if (dir.equals("N") && rot.equals("L")) { return "W";}	
		else if (dir.equals("E") && rot.equals("R")) { return "S";}
		else if (dir.equals("E") && rot.equals("L")) { return "N";}
		else if (dir.equals("S") && rot.equals("R")) { return "W";}
		else if (dir.equals("S") && rot.equals("L")) { return "E";}
		else if (dir.equals("W") && rot.equals("R")) { return "N";}
		return "S";
	}
	
	//called when user clicks on "Drop" button
	public void dropItems() {
		if(!inventory_map.isEmpty()) {
			
			//check if item1 is here
			try {
				String temp_loc = loc + " 1";
				Image temp_image = inventory_map.get("1");
				if(temp_image != null) {
					itemView1.setImage(temp_image);
					inventory_map.remove("1");
					items_map.put(temp_loc, temp_image);
				}	
			}
			catch (Exception e) { return; }
			
			//check if item2 is here
			try {
				String temp_loc = loc + " 2";
				Image temp_image = inventory_map.get("2");
				if(temp_image != null) {
					itemView2.setImage(temp_image);
					inventory_map.remove("2");
					items_map.put(temp_loc, temp_image);
				}
			}
			catch (Exception f) { return; }
		}
		showInventory();
	}
	
	//called when user clicks on "Pickup" button
	public void pickUpItems() {
		String[] temp_num = checkItem(loc).split(" ");
		String temp_str = loc + " " + temp_num[0];
		String temp_str2 = loc + " " + temp_num[1];
		
		//if there is an item, pick up item, remove from items_map and add into inventory_map
		if(temp_num[0].equals("1")) {
			itemView1.setImage(null);
			Image temp_image = items_map.get(temp_str);
			inventory_map.put("1", temp_image);
			items_map.remove(temp_str);
		}
		if(temp_num[1].equals("2")) {
			itemView2.setImage(null);
			Image temp_image = items_map.get(temp_str2);
			inventory_map.put("2", temp_image);
			items_map.remove(temp_str);
		}
		showInventory();
	}
	
	public void showItems(String temp) {
		//displays the item if it's here
		String[] itemResult = checkItem(temp).split(" ");
		String temp2 = temp;
		if(itemResult[0].equals("1")) {
			temp = temp + " 1";
			Image temp_item = items_map.get(temp);
			itemView1.setImage(temp_item);
		}
		if(itemResult[1].equals("2")) {
			temp = temp2 + " 2";
			Image temp_item = items_map.get(temp);
			itemView2.setImage(temp_item);
		}
	}
	
	//tempLoc: the next location coordinates
	//checks if there's an item here, if so, return which item
	public String checkItem(String tempLoc) {
		try { 
			String tempLoc2 = tempLoc;
			tempLoc2 = tempLoc + " 2";
			tempLoc = tempLoc + " 1";
			
			Image temp_item = items_map.get(tempLoc);
			Image temp_item2 = items_map.get(tempLoc2);
			
			//return 0 = no items; return 1 = item1 is present, return 2 = item2 is present
			if(temp_item == null && temp_item2 == null) {return "0 0";}
			else if (temp_item == null ) {return "2 2";	}
			else if (temp_item2 == null ) {	return "1 1";}
			return "1 2";
		}
		catch (Exception e) { return "0"; }
	}	
	//shows inventory of items picked up
	public void showInventory() {
		//clear all in case there's nothing in inventory
		inventory1.setImage(null);
		inventory2.setImage(null);
		
		try {
			Image temp_image = inventory_map.get("1");
			if(temp_image != null) {inventory1.setImage(temp_image);}
		}
		catch (Exception f) { return; }
		
		try {
			Image temp_image = inventory_map.get("2");
			if(temp_image != null) {inventory2.setImage(temp_image);}
		}
		catch (Exception f) { return; }
	}
}













