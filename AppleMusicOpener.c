#include <sys/wait.h>
#include <sys/types.h>
#include <unistd.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>

int main(){
    pid_t pid;
    char array[100];
    char* argument_list [] = {"open","-a","Music.app", NULL};
    if ((pid=fork())==0){
        chdir("..");
        printf("First Change: %s\n",getcwd(array,100));
        chdir("Applications");
        printf("Application Change: %s\n",getcwd(array,100));
        execlp("open","open","-a","Music.app",(char *)NULL);
    }
        
        //"Applications",
       
        //printf("Other Execute: %d\n",&execv);
    
}