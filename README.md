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
          - [BB-46]
          - [BB-44]
      - Created a basic Music Player gui with functional play, restart and pause button. This GUI reads a wav file and plays this file as a clip. I tried to connect both functional GUIS but each GUI was made on a different platforms so it was difficult to combine the two.
          - [BB-14]
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
      - [BB-29]created the tester for the song class (https://bitbucket.org/cs3398-s22-romulans/beat.box/src/master/src/test/SongTester.java)
          -commits:[b632892](https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/b632892105378c5d2a1fa2ff36a4c4d29fb51ebe) which checks to see if the the class works
      - [BB-29]created the tester for the Playlist class (https://bitbucket.org/cs3398-s22-romulans/beat.box/src/master/src/test/playlistTester.java)
          -commits: [b632892](https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/b632892105378c5d2a1fa2ff36a4c4d29fb51ebe) class which checks to see the playlist class works
      - [BB-40]created the export file from apple music containing playlist created (https://bitbucket.org/cs3398-s22-romulans/beat.box/src/master/BeatBox(AppleTransferPlaylist).xml) 
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
          - [BB-36] 
          - [BB-38]
      - With the help of Naomi created a sample of expected design of music player. 
          - [BB-48]
      - Create a button that once clicked by user if they liked the song will send the song to the liked playlist and be saved on the database. 
          - [BB-25]
          - Based on outline and advice given by Austin Sansing
          - Made based on single responsibility principle
      - I was able to create a scanner that will read a local file address and store song on local playlist and storage server. 
          - [BB-32]
          - Avery VanAusdal gave invaluable expertise on Path, split, and Database
 - Status:
      - Able to open Spotify/Apple application on Mac/Linux if code run on terminal
      - Begun looking into using Photoshop(Inkscape) to make nicer user design
 - Issues/Needed Fixes:
    -  Trouble Accessing Apples's and Spotify's toolbar to begin transfer of files for users
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
        
## Sprint 2

### Austin Sansing

  - Work Done:
    - [BB-62](https://cs3398s22romulans.atlassian.net/browse/BB-62) Created A Way to Import Local Playlist & Display the Results in the GUI 
        - Commit [f685157](https://bitbucket.org/cs3398-s22-romulans/%7Bbb8e6ef5-13af-4669-bce3-8c34a9c649fd%7D/commits/f6851579291c5c0684a6bb631779c7a3c43f0b84)
    - [BB-60](https://cs3398s22romulans.atlassian.net/browse/BB-60) Created A DatabaseQuery Method to Return all Playlists When Called 
        - Commit [581b3d9](https://bitbucket.org/cs3398-s22-romulans/%7Bbb8e6ef5-13af-4669-bce3-8c34a9c649fd%7D/commits/581b3d9d4a114194c31b2203968e3d5b20592ecf)
    - [BB-26](https://cs3398s22romulans.atlassian.net/browse/BB-26) Created A Display that Shows these Songs are apart of "Favorite/Liked" 
        - Commit [140bf5a](https://bitbucket.org/cs3398-s22-romulans/%7Bbb8e6ef5-13af-4669-bce3-8c34a9c649fd%7D/commits/140bf5ad858acfd2f7a6221da33bfff5f9bec192)
    - [BB-61](https://cs3398s22romulans.atlassian.net/browse/BB-61) Created A DatabaseQuery Method to Delete a Specific Playlist 
        - Commit [843a1a9](https://bitbucket.org/cs3398-s22-romulans/%7Bbb8e6ef5-13af-4669-bce3-8c34a9c649fd%7D/commits/843a1a9b30ef2371143618f17180e4d520cd24f4)

  - Acknowledgements
      - [Object-Oriented Design & Patterns 2nd Edition by Cay Horstmann](https://horstmann.com/design_and_patterns.html) for the refresher on Model-View-Controller architecture


  - Summary of Work Done:
      - Created a method to be able to import local playlist utliziling our new controller implementation.
      - Created a method that is the basis to my import local playlists function, allowing the controller to return all playlist found.
      - Created a method that shows what songs are liked or favorites of the user.
      - Created a method that allows the user to delete a specific playlist if it is no longer wanted.

  - Status:
      - Able to import local playlist that are saved on the computer and in return display the playlists on the GUI.
      - Able to return all playlist that are found on the computer as well as a way to delete playlists as well.
      - Able to visually see on the GUI, songs that are classified as liked or favorited by the user and storing these songs on a new playlist.

  - Issues/ Needed Fixes:
      - Need to find a more efficient way to designate liked or favorited songs. I could refactor the code to allow it to run faster utilizing SOLID principles.
      - Need to work with Naomi on the next sprint to ensure back-end and front-end are functioning with no bugs that have not been seen yet.

  - Sprint 3 Expectations:
      - Work with Avery on the back-end to ensure the majority of the back-end methods and functionalites are following SOLID principles with helpful code documentation.
      - Work on creating more tests for the overall program, to ensure bugs are not hiding within our code that we can't see currently.
      - Complete or 3/4 fully functioning front-end to back-end functionality, while adding new features if time allows.

### Avery VanAusdal

- Work Done:
  - [BB-56](https://cs3398s22romulans.atlassian.net/browse/BB-56): Created a Controller class for MVC architecture/linking allowing the GUI access to the backend
    - Commit: [119d9ed](https://bitbucket.org/cs3398-s22-romulans/%7Bbb8e6ef5-13af-4669-bce3-8c34a9c649fd%7D/commits/119d9ed057daa9969ac0fedfb98af1bd704a1e33)
  - [BB-59](https://cs3398s22romulans.atlassian.net/browse/BB-59): Created a method for Controller to list all unique artists in the Database
    - [Pull Request](https://bitbucket.org/cs3398-s22-romulans/%7Bbb8e6ef5-13af-4669-bce3-8c34a9c649fd%7D/pull-requests/5), Commits: [ee1f31e](https://bitbucket.org/%7B%7D/%7Bbb8e6ef5-13af-4669-bce3-8c34a9c649fd%7D/commits/ee1f31e169089e55185d822aef0794fd53452068), [805f04a](https://bitbucket.org/%7B%7D/%7Bbb8e6ef5-13af-4669-bce3-8c34a9c649fd%7D/commits/805f04ac479128ea80a124d77ab585877d070bd2)
  - [BB-69](https://cs3398s22romulans.atlassian.net/browse/BB-69): Created CloudPlaylistImporter interface for service decoupling
    - Commits: [8ca5ab2](https://bitbucket.org/%7B%7D/%7Bbb8e6ef5-13af-4669-bce3-8c34a9c649fd%7D/commits/8ca5ab2f1b8e083538293c389bbb280fcc8bded3), [b74469b](https://bitbucket.org/%7B%7D/%7Bbb8e6ef5-13af-4669-bce3-8c34a9c649fd%7D/commits/b74469b413b7bea25d36f0fcb8d6874fde7ee63d)
  - [BB-70](https://cs3398s22romulans.atlassian.net/browse/BB-70): Created SpotifyImporter class extending CloudPlaylistImporter which allows for entire Spotify playlists (by URL) to be converted to local Database objects
    - [Pull Request](https://bitbucket.org/cs3398-s22-romulans/%7Bbb8e6ef5-13af-4669-bce3-8c34a9c649fd%7D/pull-requests/6), Commits: [25d9b6c](https://bitbucket.org/%7B%7D/%7Bbb8e6ef5-13af-4669-bce3-8c34a9c649fd%7D/commits/25d9b6ccdc13772b77c6741343a91255c6cf52b2), [4dc36d3](https://bitbucket.org/%7B%7D/%7Bbb8e6ef5-13af-4669-bce3-8c34a9c649fd%7D/commits/4dc36d3e419c898660758ce43ce5b8cdb8b00ca2), [bf93adb](https://bitbucket.org/%7B%7D/%7Bbb8e6ef5-13af-4669-bce3-8c34a9c649fd%7D/commits/bf93adb00cc4394f71e3b2305870b78105ee304b)

- Acknowledgements:
  - [Spotify Web API Java](https://github.com/spotify-web-api-java/spotify-web-api-java) for the massive help streamlining Spotify authentication and HTTPS requests
  - [Object-Oriented Design & Patterns 2nd Edition by Cay Horstmann](https://horstmann.com/design_and_patterns.html) for the refresher on Model-View-Controller architecture
- Summary of Work Done:
  - Much of my time this sprint was focused on clear, seperated class responsibilities, such as creating the Controller class so the GUI will be updated, and moving some methods into a new class DatabaseQuery for operations more complicated than Database itself should be responsible for.
  - The other half was spent laying the foundation for Spotify imports; the SpotifyImporter class is now ready to import playlists simply when provided the URL.
- Status:
  - From the lens of model-view-controller architecture, the model and controller are practically done. The view (GUI) is barebones but has most of what it needs to use from here on out.
  - Currently, we have functionality for importing from local folders and Spotify, as well as the ability to store those playlists between app launches.
- Issues/ Needed Fixes:
  - Our Spotify authentication currently doesn't support an authorization level high enough for exporting, which will need to be added later
  - May need user input validation soon
- Sprint 3 Expectations:
  - We'll mostly work on getting the GUI together and using the rest of the codebase, which will likely lead us to identify problems or missing functionality that we couldn't see before.
  - A good bit of refactoring and class diagrams for easier navigation

### Naomi Padilla 

  - Work Done:
    - [BB-16]Created A DatabaseQuery Methods that deletes a playlist by its index and can rename a playlist
        - Commit [a979eb7](https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/a979eb730bbb2ea4867b5df5ceeb738d0c72ed9e)
    - [BB-53]Created A Playlist Frame that works with the controller which displays playlist that are in the database. From the input of the user the GUI will then display the desired playlist contents. 
        - Commit [db74d64](https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/db74d64752fb1ae4a72c5f7b3a9f83802d358a45)
    - [BB-54]Created A Artist Frame that works with the controller that displays all the artists that are in the database. From the input of the user the GUI will then display the desired artist songs. 
        - Commit [e22b4c5](https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/e22b4c56b489b54ddc314eafb0d197e07347f823)
    - [BB-55]Created A Method in controller to Display all the songs for a request artist on the Artist Frame. 
        - Commit [e22b4c5](https://bitbucket.org/cs3398-s22-romulans/%7Bbb8e6ef5-13af-4669-bce3-8c34a9c649fd%7D/commits/843a1a9b30ef2371143618f17180e4d520cd24f4)
   
    
  - Summary of Work Done:
     - I also did research on MVC (model, View, Control), to ensure our project is following the Single Responsibility. With gathering infomation about this design pattern as a group we were able to discuss on how we could write our program to efficiently access information without having our Frames do multiple tasks.  
         
    - I worked on Both PLaylist and Arist Frame that used the controller to access the database and display the desired content of songs or artist songs based on the users input.
        -    By doing this I'm making sure the frames are following the solid principles.    
    - I also created functions for the controller and DatabaseQuery that Frames will be used to display the different contents of the database. 
        -  The function displayArtistContents in controller takes in the users input that uses all other functions to gather all songs related to that artist in the database. 
    
    
  - Status:
    - As of right now both frames build and display. When the the userinput is processed it displaylist playlist not found. That is due to not having a database with any info. If anything else inserted that is not an interger on the playlist page it will show an error to reenter requested playlist.
    - All methods I made are functioning, one of them is specifically working with the GUI to display the the songs of the artist given from the userinput.

  - Issues/ Needed Fixes:
    - There could be a possibile disscusion on if all the Frames/GUIs should have its own controller. As of right now there is only one controller between the artist and playlist frame and the controller class is already doing multiple tasks that are very similar. 
        -   All the controllers could be a basic interface because they display the contents based off the users input, but differ in the information its displaying ex: arist, songs, playlist etc.
    
  - Sprint 3 Expectations:
      - For the next sprint All frames should be able to access and perform all the methods that allows the user to recieve information based on their input.
      - Want to create a button on every frame that could lead you to another frame based on what the user is wanting too access.
      - Testcase for all the Frames to insure the database is being accessed and displaying desired content correctly.
### Template (Name goes here)

  - Work Done:

  - Acknowledgements:

  - Summary of Work Done:

  - Status:

  - Issues/ Needed Fixes:

  - Sprint 3 Expectations:
    
Nelson Uzoaru

- Work Done: 
  - [BB-57]: (https://cs3398s22romulans.atlassian.net/jira/software/projects/BB/boards/3?assignee=61e72f3209633b0069bfc5c0&selectedIssue=BB-57)Create DatabaseQuery method to return a requested Playlist
       - Commit: [1b15ba2](https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/1b15ba20eba15585ee5cc3389bd64be619d16ef0)
       - Pull request [4fbc0f8] (https://bitbucket.org/cs3398-s22-romulans/beat.box/pull-requests/4/bb-57)
  - [BB-66]: (https://cs3398s22romulans.atlassian.net/jira/software/projects/BB/boards/3?assignee=61e72f3209633b0069bfc5c0&selectedIssue=BB-66) Create a DatabaseQuery method for renaming a specified Playlist
    - Commit: [f15c8b4] (https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/f15c8b451f133b07fbfae73f700704768c5357d5)
- Summary of work done:
  - creating methods that allow to pull playlists from the database
  - creating a method to allow renaming desire playlist from database
- Status:
  - Completed backend work to front end
- Issues/Needed Fixes:
  - Discuss with teammates how we are going to approach display of playlist onto the front end of the app
- Spring 3 Expectations:
  - Finish and complete GUI
### Libin Koyikalathu

  - Work Done:
    - [BB-31](https://cs3398s22romulans.atlassian.net/browse/BB-31): Create a Test to see in favorite songs store inside favorite Playlist in Database
        - Commit [0e36f12](https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/0e36f1281dc9dabe569ed17e4289b89c979bea1f)
        - Pull Request [f5c52d7](https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/f5c52d738042bb383f56c0f164b2c98834174d66)
    - [BB-63](https://cs3398s22romulans.atlassian.net/browse/BB-63): Create a function that returned a specific artists songs from Database to Database Query which can move to controller and be seen on gui
        - Commit [036f5d9](https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/036f5d92ebdce4b3e7a3fdf60ecabb19b3634683)
        - Pull Request [1b4ab71](https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/1b4ab7112ae08b1c925dae9265768729836ca495)
    - [BB-64](https://cs3398s22romulans.atlassian.net/browse/BB-64): Created a function that would remove a song from specific artist playlist stored in database
        - Commit [a16aeb0](https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/a16aeb058c54b5cd36b6ae506535117c2e26ca61)
        - Pull Request [39b3045](https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/39b3045a9613f604d94121dd8fe5f25f21817a64)
    - [BB-67](https://cs3398s22romulans.atlassian.net/browse/BB-67): Remake an already made java class of favorite playlist and fit into MVC architecture design
        - Commit [7e68583](https://bitbucket.org/cs3398-s22-romulans/beat.box/commits/7e6858343f007a83ff8b523cfc0a1188b94508dc)
  - Summary of Work Done:
      - Collaborate on how to implement MVC and provide modularity for our gui and back end code
      - Made code that allowed gui limited access to information through controller and Database Query
      - Refactor and existing class already created
  - Status:
      - Have a working MVC model
      - Almost all back end work of music player done

  - Issues/ Needed Fixes:
      - Discuss with teammates on how actual music files are gonna be store and actually store the mp3 or wav files on user end so when open they can see
      - A more visually appealing and efficient gui
  - Sprint 3 Expectations:
      - Ensure all functions of music player are working and connected
      - A finished and complete gui
     

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