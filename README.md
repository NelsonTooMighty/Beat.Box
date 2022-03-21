# Beat.Box
> Our team is building a media platform for music playlists so listeners can save time by making sharing playlists a breeze. Beat.Box will allow users to import and export playlists to and from their favorite streaming platforms and convert their offline libraries to sharable playlists.

> By Libin Koyikalathu, Naomi Padilla, Austin Sansing, Nelson Uzoaru, and Avery VanAusdal
<!--   > Live demo [TBA](https://bitbucket.org/cs3398-s22-romulans/beat-box/src/). <!-- If you have the project hosted somewhere, include the link here. -->

## Table of Contents
* [General Info](#general-information)
* [Technologies Used](#technologies-used)
* [Features](#features)
* [Acknowledgements](#acknowledgements)

<!-- 
* [Screenshots](#screenshots)
* [Setup](#setup)
* [Usage](#usage)
* [Project Status](#project-status)
* [Room for Improvement](#room-for-improvement)
* [Contact](#contact)
* [License](#license) -->


## General Information
![Logo](https://bitbucket.org/cs3398-s22-romulans/beat.box/downloads/Beat.Box.png)

Dedicated servers for streaming and licenses with major publishers are a bit expensive for a student project, so we'll be working with what we've got.
<!-- - Provide general information about your project here.
- What problem does it (intend to) solve?
- What is the purpose of your project?
- Why did you undertake it?
<!-- You don't have to answer all the questions - just the ones relevant to your project. -->


## Technologies Used
- [Spotify Web API Java](https://github.com/spotify-web-api-java/spotify-web-api-java), a Java wrapper for Spotify's API on GitHub
- [Soundiiz](https://soundiiz.com/), a playlist export tool
- [Exportify](https://github.com/watsonbox/exportify), exports spotify playlists in CSV format
- [Spotify API](https://developer.spotify.com/), for music metadata and playlist information
- [Apple Music API](https://developer.apple.com/documentation/applemusicapi/), for pulling playlist information
- [Audio Fingerprint Identifier](https://github.com/itspoma/audio-fingerprint-identifying-python), for helping identify music
- [Replit](https://replit.com/), a collaborative browser IDE
- [FFmpeg](https://github.com/FFmpeg/FFmpeg), an open-source collection of tools for multimedia processing


## Features
Planned features:

- File Scanner
	- Allows users to scan their local music libraries and convert to local editable playlists
	- Avery's story corresponds to this

- Open Borders
    - Allows users to use our platform to import and export playlists to and from Apple Music and Spotify
	- Austin and Nelson's stories correspond to this

## Sprint 1:
### Naomi Rae:

  - Worked on References:
      - https://bitbucket.org/cs3398-s22-romulans/beat.box/src/master/src/main/LayoutFrame.java
      - https://bitbucket.org/cs3398-s22-romulans/beat.box/src/master/src/main/Player.java
  - Acknowledgements:
      - Designing the the basic music player I followed BRO CODE on youtube
          - https://www.youtube.com/watch?v=SyZQVJiARTQ
      - Learning about netbean and how to create a basic functional GUI I took guidance from Mahmoud Hamwi
          - https://www.youtube.com/watch?v=lg5zWJTQWx8&t=229s
  - Summary of Work Done:
      - Did research and had created a basic functional GUI on netbean. I got the buttons to lead to other GUI that we plan on creating in the next sprint are the artist and song page.
      - Created a basic Music Player gui with functional play, restart and pause button. This GUI reads a wav file and plays this file as a clip. I tried to connect both functional GUIS but each GUI was made on a different platforms so it was difficult to combine the two.
  - Status:
      - GUIs are running independently of each other. The back in has yet to connected with the front in. 
      - Have buttons visisble and functioning to where when they are pressed they lead to another GUI that we plan on creating for other features. 
      - I have music playing from beat.box.java that is controlled by buttons that are  play, restart and pause.I achieved this by reading from a local folder that was a converted .wav file.   
  - Issues/Needed Fixes:
      - Got 2 different GUI's that I tried to connect but failed to due to them being made on two different platforms. I had an issue of reading a .wav file on netbean. 
    
  - Sprint 2 Expectations:
      - Create a connection between GUI and code. 
      - Both GUI layouts needs to be designed to  have more of an appealing aesthetic. Us as a group needs agree on a design layout that we all agree upon. I would have to do more reseach on how to achieve more of a personalized look.
      - Create a export and import button.
      - create more GUIs for pages for artist, playist, songs, album
      - Create a back button 
      
### Austin Sansing:

  - Work Done:
    - Created Project Logo [Beat.Box_3.png](https://bitbucket.org/cs3398-s22-romulans/beat.box/src/master/src/Beat.Box_3.png)
        - Commit [2f742fb](https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/2f742fb69179b7291730eb80e0c92b99d597fc26)
    - Created Background Logo Java Class [Beat.Box.java](https://bitbucket.org/cs3398-s22-romulans/beat.box/src/master/src/Beat.Box.java)
        - Commit [2f742fb](https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/2f742fb69179b7291730eb80e0c92b99d597fc26)
    - Created extracted spotify playlist [likedsong.csv](https://bitbucket.org/cs3398-s22-romulans/beat.box/src/master/likedsong.csv)
        - Commit [2acaade](https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/2acaadea39211f88acf7c46bb33b0df6f65058f1)
    - Created & Converted [likedSongsSpotify.xml](https://bitbucket.org/cs3398-s22-romulans/beat.box/src/master/likedSongsSpotify.xml)
        - Commit [9e3e222](https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/9e3e222f4853cac66b1c0ea260253917b216eefd)
    - Created Read & Store of Loval Files [Player.java](https://bitbucket.org/cs3398-s22-romulans/beat.box/src/master/src/main/Player.java)
        - Commit [243bfcc](https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/243bfcc82687db4818ac9f3d322438221c91de61)
  - Acknowledgements:
    - Logo Creation
      - https://www.canva.com
    - Spotify API
      - https://developer.spotify.com/
  - Summary of Work Done:
    - For the GUI, I created the logo that was implemented in the top right of our GUI. This logo will later be the background of both the GUI and the website.
    - Extracted my personal playlist from spotify and created a CSV from it.
    - Converted the extracted spotify playlist to an XML file for music conversion.
    - Created a way to locally read music files on the users computer.
    - Created a way to locally store music files on the users computer.
  - Status:
    - Able to use the logo for an aspect of the GUI,need to research how to place it as the background.
    - Able to store local music files and read from the stored files utilizing a vector.
    - Begin working with Avery and Naomi to link the backend code we have running to the GUI for full funcionality.
  - Issues/ Needed Fixes:
    - Background Image creation using the logo for the program.
    - Need to improve coding structure when integrating the backend to the GUI.
    - Need to become more familiar with GitKraken and other softwares used in class to better represent contributions to the team.
    - Looks into better ways to store music files, creating faster read and write times.
  - Sprint 2 Expectations:
    - Continue to intigrate the backend code we have and improve upon the functionality of the GUI.
    - Cleaner GUI apperance will fully functioning buttons and displays.
    - Spotify and Apple API conversion, to be able to find songs on the different platforms.
    
### Avery VanAusdal:
    
  - Work done:
      - Created [Song Class](https://bitbucket.org/cs3398-s22-romulans/beat.box/src/master/src/main/Song.java) for representing individual tracks
        - Commits: [9b0d34c](https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/135d6d89d411af15e5fd401c1cf3df8da517ef66) and [135d6d8](https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/b4c8b6599d9c60c0f6dca9ffd3cb96f14f6171c0)
      - Created [Playlist Class](https://bitbucket.org/cs3398-s22-romulans/beat.box/src/demo/src/main/Playlist.java) which stores Song objects as a linked list
        - Commits: [4b85687](https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/4b856872aa0f28466b6b65b47fed8367d106c186) and [bd56e74](https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/bd56e74e10ff294d743a398a83a297c2637d99a3)
      - Created [Database Class](https://bitbucket.org/cs3398-s22-romulans/beat.box/src/demo/src/main/Database.java) to store and manage Playlist objects using the Singleton pattern, includes a Playlist serializer and de-serializer
        - Commits: [8bd1765](https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/8bd1765a6293aad9873df597ce353af45be77bcb) and [
          bd56e74](https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/bd56e74e10ff294d743a398a83a297c2637d99a3)
        - Created [TestDatabase Class](https://bitbucket.org/cs3398-s22-romulans/beat.box/src/master/src/test/TestDatabase.java) to test serializer functionality and correctness
          - Commit: [1624672](https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/1624672e92e22095d7fe3c447714df6fd4ee954e)
      - Set up Gradle build capabilities
        - Commit: [f0f9222](https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/f0f9222c101b3c697b1d1c4cd98e45756877f03e)
  - Acknowledgements:
    - [Gradle docs](https://docs.gradle.org/7.3.3/userguide/java_testing.html) for Java build and test integration
    - [LogicBig tutorial on DirectoryStream objects](https://www.logicbig.com/how-to/code-snippets/jcode-java-io-files-newdirectorystream.html) for help with parsing through file directories
    - [TutorialsPoint tutorial on Java Serialization](https://www.tutorialspoint.com/java/java_serialization.htm) for help with saving playlists to the disk
  - Status:
    - For the backend, we have the basics (Songs stored in Playlists stored in the Database) but will need additional higher-level classes for interfacing with the GUI/user
    - User input for using the backend is currently not implemented in any form
  - Issues/Needed Fixes:
    - Need to fix local path issues caused by Gradle restructuring our directory
    - Need to improve documentation/comments on my existing classes to help teammates ([Javadocs](https://www.jetbrains.com/help/idea/working-with-code-documentation.html))
  - Sprint 2 Goals:
    - Continue adding backend functionality
        - work on the unfinished Folder Scanner project, for importing folders of local music into playlists
        - create a wrapper class for "buttons" which hold Playlist(s) and have functions for interacting with them (add, remove, reorder, export)
        - start the dependent Song Identifier functionality to allow for downloading song metadata and album cover art
    - Add and improve unit tests
    - Provide backend support to teammates for easier GUI integration
    - If I have time, an iterator in the Playlist class that only parses through local files (for playback)
### Nelson Uzoaru:

  - Worked on References:
      - https://bitbucket.org/cs3398-s22-romulans/beat.box/src/master/src/test/
      - created the tester for the song class (https://bitbucket.org/cs3398-s22-romulans/beat.box/src/master/src/test/SongTester.java)
          -commits:[b632892](https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/b632892105378c5d2a1fa2ff36a4c4d29fb51ebe) which checks to see if the the class works
      - created the tester for the song class (https://bitbucket.org/cs3398-s22-romulans/beat.box/src/master/src/test/playlistTester.java)
          -commits: [b632892](https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/b632892105378c5d2a1fa2ff36a4c4d29fb51ebe) class which checks to see the playlist class works
      - created the export file from apple music containing playlist created (https://bitbucket.org/cs3398-s22-romulans/beat.box/src/master/BeatBox(AppleTransferPlaylist).xml) 
          -commits: [e46d7b6] (https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/e46d7b6d7acc56ef030142a8f91e80eb469b616e) files exported from apple music
  - Acknowledgements: Avery VanAusdal for helping me out and giving me pointers for where to start on the testers. 
        - Used professors tester format from the JUnit testing from his hello gradle files, tested in class.
        - apple music to create a sample playlist, and then exporting from. 
  - Summary of Work Done:
      - Created a tester classes for both song and playlist classes done 
      - created an export from apple music containing a playlist 
  - Status: Completed my tester classes
  - Issues/Needed Fixes:
   - Better understanding of how GitKraken, BitBucket, and Jira work
  - Sprint 2 Expectations:
    - Continue to build on testers needed for classes created for the player.
    -
    -
### Libin Koyikalathu:

  - Worked on References:
      - https://bitbucket.org/cs3398-s22-romulans/beat.box/src/master/SpotifyMusicOpener.c
      - https://bitbucket.org/cs3398-s22-romulans/beat.box/src/master/AppleMusicOpener.c
      - https://bitbucket.org/cs3398-s22-romulans/beat.box/src/master/src/main/FavoritePlaylistCreator.java
      - https://bitbucket.org/cs3398-s22-romulans/beat.box/src/master/src/main/folderScanner.java
      - https://bitbucket.org/cs3398-s22-romulans/beat.box/src/master/Website%20Layout.png
  - Acknowledgements:
      - The design of the website template sketch is based on by [Pandora],[Spotify] and a tutorial from [Satori Graphics] from youtube.
          - www.pandora.com
          - www.spotify.com
          - https://www.youtube.com/watch?v=eiV7E_LVlxs&ab_channel=SatoriGraphics

      - The operating systems code to open Apple Music is based from Xiao Chen lab 1 homework and [linuxHint.com]
          - https://linuxhint.com/c-chdir-function-usage/
  - Summary of Work Done:
      - Created two classes which can open spotify and apple music with a linux/apple system
      - With the help of Naomi created a sample of expected design of music player.
      - Create a button that once clicked by user if they liked the song will send the song to the liked playlist and be saved on the database. 
        - Based on outline and advice given by Austin Sansing
        - Made based on single responsibility principle
      - I was able to create a scanner that will read a local file address and store song on local playlist and storage server.
        - Avery VanAusdal gave invaluable expertise on Path, split, and Database
  - Status:
      - Able to open Spotify/Apple application on Mac/Linux if code run on terminal
      - Begun looking into using Photoshop(Inkscape) to make nicer user design
  - Issues/Needed Fixes:
      - Trouble Accessing Apples's and Spotify's toolbar to begin transfer of files for users
      - Liked Playlist is missing a tester class
      - folderScanner class missing a test
  - Sprint 2 Expectations:
      - A finished detailed outline of GUI that is presentable 
      - Have finish java classes that can
        - run a c code
        - open Spotify/Apple on any operating system and initiate transfer/import
        - reads xml file and transfers it into Database
        - export song info from Database to Spotify/Apple
        - unification of different classes above to run task
        
    
## Acknowledgements
Give credit here.
- This project was inspired by...
- This project was based on [this tutorial](https://www.example.com).
- Many thanks to...
-  ()
- ().
- (), 
- ()

<!--
## Screenshots
![Example screenshot](./img/screenshot.png)
<!-- If you have screenshots you'd like to share, include them here. -->

<!--
## Setup
What are the project requirements/dependencies? Where are they listed? A requirements.txt or a Pipfile.lock file perhaps? Where is it located?

Proceed to describe how to install / setup one's local environment / get started with the project.

<!--
## Usage
How does one go about using it?
Provide various use cases and code examples here.

`write-your-code-here`

<!--
## Project Status
Project is: _in progress_ / _complete_ / _no longer being worked on_. If you are no longer working on it, provide reasons why.

<!--
## Room for Improvement
Include areas you believe need improvement / could be improved. Also add TODOs for future development.

Room for improvement:
- Improvement to be done 1
- Improvement to be done 2

To do:
- Feature to be added 1
- Feature to be added 2





## Contact
Created by [@flynerdpl](https://www.flynerd.pl/) - feel free to contact me!


<!-- Optional -->
<!-- ## License -->
<!-- This project is open source and available under the [... License](). -->

<!-- You don't have to include all sections - just the one's relevant to your project -->