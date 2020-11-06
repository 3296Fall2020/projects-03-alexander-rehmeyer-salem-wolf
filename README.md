### Minecraft Forge Mod (TempleUtilities / TUtilities / TUtils) - Final Project

#### Project Abstract
The purpose of this project is the creation of a mod for the game Minecraft using Minecraft Forge, an open-source project that allows Java developers to view and modify the game’s code as well as load mods into a running instance of the game. I intend for this project to include the addition of relatively simple quality-of-life improvements for Minecraft’s basic gameplay loop. I plan to add new items to the game as well as additional functionalities for existing items. Developers will be programming mostly in Java. I recommend Eclipse for Java as the IDE for this project, but any development environment that can import Gradle projects will work just fine

#### Project Relevance
The objectives of this project coincide perfectly with the educational objectives of this course. The developers will be required to study and modify code written in an object-oriented style, work with multiple GUI, and test and debug the mod to ensure that it does not cause any game-breaking conflicts in the game’s code.

#### Conceptual Design

The mod we are proposing would make the following additions to the game:
* Additional tools that combine the functionalities of existing tools to allow for easier resource collection and navigation of the game-world
* New crafting recipes to allow players easily obtain items that are usually difficult to get
* Add new crafting stations that allow for more efficient resource processing
* New randomly generated structures

### Project Background:
[Minecraft Forge Documentation](https://mcforge.readthedocs.io/en/1.14.x/concepts/sides/)
[Minecraft Forge Github](https://github.com/MinecraftForge/MinecraftForge/tree/1.12.x)
[MCForge Download](https://files.minecraftforge.net/maven/net/minecraftforge/forge/index_1.12.2.html)
[My Repo](https://github.com/CollinRehmeyer-templeU/myMod)

### Building the Project
* Requires JDK 8, Gradle, and a Java IDE (I used Eclipse)
* Download MC Forge 1.16.3 MDK (Mod Development Kit) and extract zip, import to IDE as a Gradle Project

### Running the Project
* Run “fg_runs” Gradle Task in the imported Gradle project
* File > Import > Run/Debug > Launch Configurations
* Import RunClient
* Change MC Version Environment Variable to 1.16 in Run Configuration
* Run using RunClient configuration, this will launch the Minecraft Client

### Link to Presentation Slide
[My Presentation Slide](https://github.com/CollinRehmeyer-templeU/myMod/blob/master/Slide.pdf)


##### Product Vision :
---
For Minecraft players of any level of experience who are looking for simple quality of life improvements to the game. TUtilities is a lightweight, simple mod that, unlike other popular minecraft mods, is focused more on enhancing the vanilla Minecraft experience than extending it

##### Personas :
###### Jonathan, a young student
---
Jonathan, age 13, is a teenager who recently started playing video games because of the influence of gaming influencers on YouTube and Twitch. He comes from a middle-class family, so they do not have spare funds lying around for video games. Jonathan has an older brother, Peter, who plays a lot of video games, and since Jonathan looks at his older brother as a role model, he wants to start playing video games too. Peter has recently allowed Jonathan to start playing one of his games, Minecraft. When Jonathan goes to middle-school each day, he primarily discusses the video game concepts where he is having a hard time with his friends during recess and lunch. Other than school and video games, as a child, Jonathan, does not have any responsibility, so his primary focus is currently Minecraft.
Being a younger boy in today’s day-of-age, Jonathan obviously knows how to use most of today’s common technology such as any Apple product and PCs, so he is adept at using technology at a young age. Although, he is having a hard time understanding all the new concepts that are introduced to you when you first begin playing Minecraft. Rather than ask his brother, Jonathan wants to learn easiest and fastest strategies for playing the game on his own. He wants to quickly beat the game so that he can impress his brother too.

###### Charlie, a college sophomore
---
Charlie, 20, is a sophomore college student who has been playing Minecraft since early middle school. An avid user of mods and modpacks, Charlie has had a lot of experience with mods that significantly alter the gameplay of Minecraft, from mods that introduce technology trees and automation to ones that add new mobs and bosses. At this point, Charlie has become quite skilled at installing and using mods by browsing forums and reading guides. Recently, Charlie has been missing the feel of vanilla Minecraft, but has been somewhat "spoiled" by the features that a lot of popular mods offer, and is finding it hard to not get irritated when things in the un-modded game get tedious. Charlie is intrigued by TUtils as it fixes a lot of the tedium of vanilla Minecraft without significantly altering the simple feel of the game, as well as not requiring a tremendous amount of effort to learn to use. 

###### Michal, a high school student and games enthusiast
---
Michal is a high school student who loves playing games that involves puzzles and some sort of complex problem solving. He likes to play games that involve creative thinking and circuit designing. Minecraft is a game that both involves those two aspects and he already is a consistent player of the game. He knows how to design many Redstone circuits in the game already and is involved in Minecraft mods and the community in general. As Minecraft gets bigger, the number of items and possibilities increase with every update. He would like to use a mod that adds simple quality of life improvements and blocks that make it easier to manage the ever-expanding universe of possibilities in the game. Blocks that help with his designing and sorting his storage as well as few game additions blocks that expand on block usages. The mod is also a lightweight one that is concerned with quality of life changes to the mod to make the game easier to manage mainly in vanilla Minecraft.

###### Louis, a college junior
---
Louis, a junior in college, used to play Minecraft as a child, but as he grew older he played it less and less. As a child he had a lot of experience with the game and came to know it very intimately. He always enjoyed working with the redstone aspect of the game and grew quite adept with it, often making intricate projects. However, as he grew older he played the game less and less until he stopped playing it entirely. Recently, while watching one of his favorite video game streamers, he became interested in the game again. When he returned to it, he noticed how it has changed greatly since he last played it, as well as the great availability of mods for the game. He found several aspects of the interface to be troublesome and could easily be fixed; he also believes the biomes and structures to be rather limited. He is interested in a mod that could address both of these things, improving the interface as well as providing a greater variety of structures.


##### FORGE README
-------------------------------------------
Source installation information for modders
-------------------------------------------
This code follows the Minecraft Forge installation methodology. It will apply
some small patches to the vanilla MCP source code, giving you and it access 
to some of the data and functions you need to build a successful mod.

Note also that the patches are built against "unrenamed" MCP source code (aka
srgnames) - this means that you will not be able to read them directly against
normal code.

Source pack installation information:

Standalone source installation
==============================

See the Forge Documentation online for more detailed instructions:
http://mcforge.readthedocs.io/en/latest/gettingstarted/

Step 1: Open your command-line and browse to the folder where you extracted the zip file.

Step 2: You're left with a choice.
If you prefer to use Eclipse:
1. Run the following command: "gradlew genEclipseRuns" (./gradlew genEclipseRuns if you are on Mac/Linux)
2. Open Eclipse, Import > Existing Gradle Project > Select Folder 
   or run "gradlew eclipse" to generate the project.
(Current Issue)
4. Open Project > Run/Debug Settings > Edit runClient and runServer > Environment
5. Edit MOD_CLASSES to show [modid]%%[Path]; 2 times rather then the generated 4.

If you prefer to use IntelliJ:
1. Open IDEA, and import project.
2. Select your build.gradle file and have it import.
3. Run the following command: "gradlew genIntellijRuns" (./gradlew genIntellijRuns if you are on Mac/Linux)
4. Refresh the Gradle Project in IDEA if required.

If at any point you are missing libraries in your IDE, or you've run into problems you can run "gradlew --refresh-dependencies" to refresh the local cache. "gradlew clean" to reset everything {this does not affect your code} and then start the processs again.

Should it still not work, 
Refer to #ForgeGradle on EsperNet for more information about the gradle environment.
or the Forge Project Discord discord.gg/UvedJ9m

Forge source installation
=========================
MinecraftForge ships with this code and installs it as part of the forge
installation process, no further action is required on your part.

LexManos' Install Video
=======================
https://www.youtube.com/watch?v=8VEdtQLuLO0&feature=youtu.be

For more details update more often refer to the Forge Forums:
http://www.minecraftforge.net/forum/index.php/topic,14048.0.html
