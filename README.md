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

# Naomi Rae:
    * ## Worked on References:
      * ### https://bitbucket.org/cs3398-s22-romulans/beat.box/src/master/src/main/LayoutFrame.java
      * ### https://bitbucket.org/cs3398-s22-romulans/beat.box/src/master/src/main/Player.java
    * ## Acknowledgements:
      * ###
      * ###
      * ###
    * ## Summary of Work Done:
      * ###
      * ###
      * ###
    * ## Status:
      * ###
      * ###
      * ###
    * ## Needed Fixes:
      * ###
      * ###
      * ###
    * ## Sprint 2 Expectations:
      * ###
      * ###
      * ###

    
## Acknowledgements
Give credit here.
- This project was inspired by...
- This project was based on [this tutorial](https://www.example.com).
- Many thanks to...
- The design of the website template sketch is based on by [Pandora](www.pandora.com) [Spotify](spotify.com) and a tutorial from
[Satori Graphics] from youtube (https://www.youtube.com/watch?v=eiV7E_LVlxs&ab_channel=SatoriGraphics)
- The operating systems code to open Apple Music comes from Xiao Chen lab 1 homework and 
  linuxHint.com(https://linuxhint.com/c-chdir-function-usage/).
-Designing the the basic music player I followed BRO CODE on youtube (https://www.youtube.com/watch?v=SyZQVJiARTQ), 
-Learning about netbean and how to create a basic functional GUI I took guidance from Mahmoud Hamwi (https://www.youtube.com/watch?v=lg5zWJTQWx8&t=229s)
## done items
- Naomi did research and has created a basic functional GUI on netbean. I got the buttons to lead to other GUI that we plan on creating in the next sprint 
 are the artist and song page. // 
 -Naomi got done a basic Music Player gui with functional play, restart and pause button. This GUI reads a wav file and plays this file as a 
  a clip. She tried to connect both functional GUIS but each GUI was made on a different platforms so it was difficult to combine the two. 
   
-Libin has created two classes which can open spotify and apple music with a linux/apple system https://bitbucket.org/cs3398-s22-romulans/beat.box/src/master/SpotifyMusicOpener.c , 
 , https://bitbucket.org/cs3398-s22-romulans/beat.box/src/master/AppleMusicOpener.c
 -Libin created a liked playlist in which contains a button in the shape of our logo, once it is clicked it will add on to a liked playlist and be saved on 
  the database // https://bitbucket.org/cs3398-s22-romulans/beat.box/src/master/src/main/FavoritePlaylistCreator.java

- Nelson created tester classes for both song and playlist classes, https://bitbucket.org/cs3398-s22-romulans/beat.box/src/master/src/test/

## sprint two goals 
-Naomi is expected to design future layouts for the music player and the front end of the GUI.
 cleaner and appealing design that we all will discuss before the next sprint starts. This sprint the backend and front-end arent
  connected this sprint but do plan for there to be an established connection with basic functionality. 
 

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