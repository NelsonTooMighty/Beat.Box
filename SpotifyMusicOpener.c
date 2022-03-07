#include <sys/wait.h>
#include <sys/types.h>
#include <unistd.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>

int main(){
    pid_t pid;
    char array[100];
    
    if ((pid=fork())==0){
        
        chdir(".."); //Changes to basic Directory

        //printf("First Change: %s\n",getcwd(array,100));

        chdir("Applications"); //changes to Applications

        //printf("Application Change: %s\n",getcwd(array,100));

        execlp("open","open","-a","Spotify.app",(char *)NULL); // terminal code that opens Spotify Music
    }
       // to run code use terminal and enter: gcc SpotifyMusicOpener.c -o spotify
        // then type ./spotify
    
    
}