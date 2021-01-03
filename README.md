# Brite
A minecraft forge mod for Hypixel skyblock

### General mod information<br>
All menus are saved when you are done interacting when them. ie creating a new menu, deleting one, moving one etc.
Each account will need to set its own API key to use the mod.
The requests are sent to the server every 5 seconds meaning 12 requests per minute, although due to some issues in the timing in java can reach a a max of 16 requests per minute (this is due to time drift when using the ScheduledExecutorService when the computer enters a suspended state).

### How to build the mod:<br>
Step 1: clone this repository to a file on your machine.<br>
Step 2: Open a command prompt and navigate to the file.<br>
Step 3: Run 'gradlew build'

### How to install the mod:<br>
After building it as outlined in the previous section, go to the build/libs folder and copy the jar file into your mods folder. Make sure you copy the the normal one, not the sources jar file.

### Using the mod<br>
To use the mod you first must set the api key, you can get your key by doing /api ingame.<br>
Then you use "/brite setkey APIKEY" Replace the APIKEY part with the api that is generated for you by running the /api command.<br>
Then do "/brite enable" This will enable the mod and start the request scheduler to communicate with the api server.<br>
Also if you want to disable the mod use "/brite disable" This will disable all menus, and stop the request scheduler.
Then you can use "/brite" to get to the menu where you can add, move, delete, and enable or disable the menus. Note you cannot currently edit menus, that functionality will be added soon though.<br>
Other commands to use:<br>
  - "/brite scale VALUE" This will scale all the menus by a certain value. 1 is the default<br>
    - Example: "/brite scale .5" will shrink all the menus by half<br>
  - "/brite scale VALUE NAME" This will scale only the menu with that name by the value<br>
    - Example: "/brite scale .5 Items" will scale the menu Items by half. Note if the menu name has a space in it type it in as normal.<br>
    - Example: "/brite scale .5 Cool Items"<br>
   - "/brite toggle Name" Will toggle a menu's enable/disable status this is similar to the enable/disable menu but is quicker to use<br>
