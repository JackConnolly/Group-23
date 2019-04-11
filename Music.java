import java.io.File;
import  java.io.*;
import java.lang.Object;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;


import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;

import java.lang.NumberFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Reader;
import java.io.FileWriter;
import java.io.InputStreamReader;

import java.lang.Object;
import javax.sound.sampled.AudioSystem;
import java.io.File;
import java.io.FileReader;
import javax.sound.sampled.Clip;

import java.util.ArrayList;

/**
* This is the Music Class which will be called
* on in BoardGUI to play music
* @author Jack Connolly, Anna Barrett, Kylie Sicat, Hailey Allen, Jung Ho Kim
* last updated by: Hailey Allen
* @since 04-07-19
*/

public class Music{

/**
Default constructor for class
Music
*/

	public Music(){

	}

	public static void main(String[] args) throws Exception{
		Music m = new Music();
		try{
			m.playMusic("C:\\Users\\Hailey\\Downloads\\j\\Final\\pinkpanther.wav");
		}
		catch(FileNotFoundException e){
			throw new Exception();
		}

	}

/**
This method calls into the specified
music location in order to play the music
in the background
@param String musicLocation
@throws Exception
@return void
*/
	
	public void playMusic(String musicLocation) throws Exception{

		try{

			File musicPath = new File(musicLocation);

//if the music pathway specified exists, follow the path to play the music
			if(musicPath.exists()){
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.loop(Clip.LOOP_CONTINUOUSLY);

//A small pane which opens and if OK is pressed, the music will stop playing and pane closes
				JOptionPane.showMessageDialog(null, "Press OK to stop playing");
			}
//If it cannot find the specified file pathway, print an error statement
			else{
				//System.out.print("cant find");
			}

		}
		catch(Exception ex){
			ex.printStackTrace();
		}

	}


}