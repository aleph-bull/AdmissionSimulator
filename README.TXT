------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all they need to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: College Admissions Simulator
PURPOSE OF PROJECT: Simulate life of a student preparing for applications + application decisions
VERSION or DATE: April 2025
HOW TO START THIS PROJECT: Open in Greenfoot, instantiate new StartingWorld() and click Run!
AUTHORS: Ehtan Ren, Angela Wang, Daniel Wang, Stephanie Xia, Zachary Zhao
USER INSTRUCTIONS: 


==============DETAILS!==============
University season is approaching! Two students are competing to see who will 
get into their dream universities. The university doesn’t just accept anyone. 
They look at how well the student is based on their GPA, and so the grind begins! 
The students are working in their room to work towards the best GPA, but there are a series of 
events (depression, sickness), the students’ relatives (mom, sister, cat, and mystery guests) and 
the students’ mental state (mood) that distract them from getting their desired GPA. After 1.5 minutes 
of grinding, the students send in their application and receive an acceptance or rejection letter 
and the grand reveal begins…

==============SETTING INSTRUCTIONS==============
The viewer gets to choose two students and one university they like. 
They then get to choose the starting status of each student, including their happiness, 
GPA, productivity and three relatives they like. 


==============MAIN FEATURES==============
WORLDS
- StartingWorld: The world users start on when the open the simulation, ft. cool gif background
- InstructionsWorld: A brief introduction of the background story of the simulation through a dialogue
- SettingsWorld: SettingsWorldGeneral, SettingsWorldS1Stats, SettingsworldS2Status - 
    Where the user can see all the variables that need to be set for the simulation, ft. cool? hoverable buttons
- MainWorld - Where the grinding for the student will happen
- AdmissionsWorld - Where student acceptance/rejection is determined based on their GPA

EFFECTS
- Depression:happiness bar -> 0, small rain cloud will appear on top of the character’s head with shadow + 
    background of room become dark for 6 seconds
- Sickness - Green virus will enter the room + background turn green -> player become sick and can not do 
    work for 6 seconds

RELATIVES
- Cat/mom/sister/capybara/amongus (sorry) occupy the workplace/phone/bed of the student, making them less productive; 
    there will be a bar on top of there head for how long they can occupy a place/object

STUDENT
- Student walks around the room at random until they encounter an item; after item encountered they will 
    do the task at that item until the task bar on top of their head goes to 0 and then they will walk around 
    the room at random again

ITEMS
- Computer: student at task: GPA increase, happiness decrease
- Phone: student at task: GPA decrease, happiness increase
- Bed: student at task: GPA decrease, happiness increase
- Each complete with sound effects!

==============KNOWN BUGS==============
- Relative may collide with wall and oscillate rapidly
- Student may appear trapped in horizontal/vertical back and forth motion??
    **Probably fixed but also potentially not - can't be 100% sure
- *Note: decided not to have Phone appear above Relatives who were using it because it just looked bad -
    this is not a bug!
- Setting music may break??? Tried redownloading through audacity etc but once in a while still breaks 
- Setting relative images has this weird order where if you start at cat --> right = mom, 
	but start at cat --> left = also mom? 
- YOU HAVE TO BEGIN THE SIMULATION FROM STARTINGWORLD!! otherwise will get nullpointerexception because of
    the way Setting world stuff sets images

==============CREDITS==============
SOUND
- AdmissionsWorld music: https://www.chosic.com/download-audio/26013/
- Button sfx: https://www.youtube.com/watch?v=BZvS2Bno8R4
- EndingWorld sad music: https://www.chosic.com/download-audio/27881/
- EndingWorld yay music: https://www.chosic.com/download-audio/27306/
- Honk mimimimi: https://www.youtube.com/watch?v=dNr7nXvntO8
- IntroductionWorld music: https://www.chosic.com/download-audio/27131/  
- Lose sfx: https://youtu.be/_asNhzXq72w?feature=shared
- MainWorld music: https://www.chosic.com/download-audio/29282/
- Phone sfx: https://youtu.be/p2rBHjShJjw?feature=shared
- Rain sfx: Light rain loop, https://mixkit.co/free-sound-effects/rain/
- SettingWorld music: Run Amok by Kevin MacLeod, https://www.chosic.com/download-audio/39324/
- StartingWorld music: Colorful Flowers by Tokyo Music Walker, https://www.chosic.com/download-audio/45508/
- Textbox sfx unknown source?
- Typing sfx: https://mixkit.co/free-sound-effects/discover/typing/ 
- Win sfx: https://www.youtube.com/watch?v=rr5CMS2GtCY

IMAGES 
- Among Us: https://among-us.fandom.com/wiki/Characters 
- Button image: https://www.freepik.com/free-vector/ui-stone-texture-game-button-frame-cartoon-vector-set-medieval-interface-board-element-kit-mobile-app-menu-with-play-pause-plus-cross-arrow-check-isolated-item-template-collection_72090679.htm#fromView=keyword&page=1&position=26&uuid=f5aa3d61-b38d-4271-a60a-af784fb75f92&query=Game+Ui+Arrow 
- Capybara: https://rainloaf.itch.io/capybara-sprite-sheet
- Cat: https://toffeecraft.itch.io/cat-pack 
- Cloud image: https://www.freepik.com/premium-vector/pixel-art-cartoon-crying-rainy-cloud-character_214146407.htm
- Germ image: https://www.freepik.com/premium-vector/bacteria-virus-pixel-art-set-germ-microbe-collection-infectious-pathogen-8-bit-sprite_33822375.htm
- IntroductionWorld bg: https://ibispaint.com/art/707595372/
- MainWorld bg: https://limezu.itch.io/moderninteriors
- Mom: ChatGPT'd
- Mood: https://actuallykron.itch.io/free-emoji-pack?download
- SettingsWorld bgs: Stephanie Xia
- Sister: chatGPT
- StartingWorld gif: https://www.artstation.com/artwork/182Z4L
- Students: https://itch.io/game-assets/free/tag-sprites 
- University images: edited by Stephanie Xia + online images???
