---
layout: page
title: User Guide
---

Momentum is a **desktop app** that **helps freelancers track time spent on different projects** and **gain insights on how their time is spent**.

It is designed for people that prefer typing, so that frequent tasks can be done faster by typing in commands.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick Start<a name="quick-start"></a>

1. Ensure you have Java `11` or above installed in your computer.

2. Download the latest `momentum.jar` from [here](https://github.com/AY2021S1-CS2103T-T10-1/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for Momentum.

4. Double-click the file to start Momentum. The GUI similar to below should appear in a few seconds. <br>
   ![Ui](images/Ui.png)

5. Type the command in the command box and press `Enter` to execute it. e.g. typing `help` and pressing `Enter` will open the help window.<br>

   Some example commands you can try:

   * `view 1` : View the tasks of project at index 1.

   * `home` : Go to home.

   * `add n/Momentum d/CS2103T Team Project` : Add a project named `Momentum` to the Project Book in project view. Add a task named `Momentum` to the project in task view.

   * `edit 3 n/NewMomentum d/newDescription` : Update the 3rd project/task in the current list. The name will be changed to "NewMomentum" and the description will be changed to "NewDescription".

   * `delete 3` : Delete the 3rd project/task shown in the current list.

   * `find n/NewMomentum` : Find a project/task that has `NewMomentum` in its name.

   * `list` : List all projects or tasks based on the current view mode.

   * `sort type/deadline order/asc` : Sort the list of projects/tasks by deadline in ascending order.

   * `start 1` : Start the timer of project/task at index 1.

   * `stop 1` : Stop the timer of project/task at index 1.

   * `exit` : Exit the app.

Refer to the [Features](#features) below for a more comprehensive set of features available in Momentum.

--------------------------------------------------------------------------------------------------------------------

## User Interface Overview

Momentum uses a GUI (Graphical User Interface) to get input from you, and display information to you. Different parts of this GUI perform different functions, as explained below:

![OverviewUI](images/OverviewUI2.png)

1. **Command Box**: The place where you enter in your commands.
2. **Results Box**: Displays the result of executing the commands that you enter.
3. **Display List**: Displays a list of projects or tasks.
4. **Reminders Panel**: This is where reminders will appear. The panel will only be present when there are reminders that have not yet been dismissed.
5. **Active Timers Panel**: Displays all the timers that are currently running.
(see [Active Timers Panel](#active-timers-panel))
6. **Statistics Panel**: Displays the statistics data calculated by Momentum.
(see [Statistics](#statistics))
7. **Tags Panel**: Displays a collection of all the tags visible in the display list.
8. **Bottom Bar**: Displays contextual information about what you are viewing, such as the specific project that you are viewing, and the number of items in the display list hidden due to finding or sorting commands.

The active timers, statistics, tags and reminders panels can be resized to display more information by clicking and dragging their edges.

### User Interface Theme

The GUI Momentum also comes with two themes, light and dark. These themes are shown below:
![GUI Themes](images/GUIThemeDiagram.png)
You can adjust the themes to your preference, by changing it in the application settings. (see [Settings](#settings))

## Command Format

Below is an explanation of the formatting used to show commands:

* Words in `UPPER_CASE` are the parameters to be supplied by the user.
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/Blog Design`.
* Items in square brackets are optional.
  e.g `n/NAME [t/TAG]` can be used as `n/Blog Design t/friend` or as `n/Blog Design`.
* Items with `…`​ after them can be used multiple times including zero times.
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.
* Items with `…` inside square brackets `[t/TAG [MORE_TAGS]...]` can take in multiple space separated arguments
  e.g. `[[t/TAG [MORE_TAGS]...]` can represent `t/friend friend family`.
* Parameters can be in any order.
  e.g. If the command specifies `n/Blog Design dd/2020-11-05`, `dd/2020-11-05 n/Blog Design` is also acceptable.

## Date and Time Terms

This is a guide to the date and time formats used in Momentum.

### Date Terms

Dates should be entered in the order `YYYY-MM-DD`.

Term  | Meaning | Example
----- |-------- | -------
`YYYY`| Year    | `2020`
`MM`  | Month   | `02`
`DD`  | Day     | `09`

**Valid**: `2020-08-02`

**Invalid**: `2-8-20` Wrong number of digits.

**Invalid**: `02-08-20` Wrong order of year, month and date.

**Invalid**: `2nd August 2020` You cannot use text to enter dates.

### Time Terms

Times should be entered in 24 hour format, in the order `HH:MM:SS`.

Term | Meaning | Example
-----|-------- | -------
HH   | Hour    | `16`
MM   | Minute  | `52`
SS   | Second  | `03`

**Valid**: `15:08:02`

**Invalid**: `15:8:2` Wrong number of digits.

**Invalid**: `8:15:2` Wrong order of hour, minute and second.

**Invalid**: `03:08:02PM` Only 24 hour time is accepted.

### Combining Date and Time

You may also have to enter both dates and times together. When entered together, dates and times should be entered in the order `YYYY-MM-DDTHH:MM:SS`. The letter `T` separates the date and time.

**Valid**: `2020-08-02T15:08:02`

**Invalid**: `15:08:02T2020-08-02` Wrong order of date and time.

## `ID` Term

* You need to enter an id which refers to the id number shown in the displayed project/task list.

* You need to enter a **positive integer** such as 1, 2, 3, …​

## Features<a name="2-Features"></a>

### Projects and Tasks<a name="3-Projects-and-Tasks"></a>

Done by: Farrell Nah Jun Hao

You can add projects into Momentum to be tracked. Each project has the following information:

* Name
* Description
* Completion Status
* Deadline Date
* Deadline Time
* Reminder
* Tag

Apart from the name, all other information is optional.

Each project can also contain several tasks, each with the same information as a project.

When you first open Momentum, you will see all the projects being tracked in Momentum. You can then view the tasks
 for each project separately. seperately using the [view command](#viewing-a-projects-tasks-view)]

<div markdown="block" class="alert alert-info">

**:bulb: Most commands in Momentum will do different things depending on whether you are viewing projects or tasks
.**<br>
Please refer to each command for these differences.

</div>

#### Viewing a Project's Tasks: `view`

Done by: Farrell Nah Jun Hao

View the tasks for a project.

Format: `view ID`

* You can refer to [`ID` Term](#id-term) for more information.

Example: `view 1`

##### Walkthrough of viewing a project's tasks
Suppose you would like to view the tasks belonging to the 2nd project in the list

![View1](images/View1.png)

1. Type `view 1` into the command box and press <kbd>Enter</kbd>

    ![View2](images/View2.png)

2. The results box will display a message to indicate that you have successfully changed your view. You should see the tasks belonging to the project in the display list.

    ![View3](images/View3.png)
    
#### View Projects: `home`

Done by: Farrell Nah Jun Hao

View all the projects being tracked by Momentum.
This is the default view you will see when Momentum is first opened.

Format: `home`

##### Walkthrough of viewing projects
Suppose you are in task view, and would like to go to project view.

![Home0](images/Home0.png)

1. Type `home` into the command box and press <kbd>Enter</kbd>

    ![Home1](images/Home1.png)

2. The results box will display a message to indicate that you have successfully changed your view. You should see the tasks belonging to the project in the display list.

    ![Home2](images/Home2.png)


#### Creating a Project/Task: `add`

Done by: Cheong Ying Yi Clara

When Momentum is in [project view](#glossary), you can use the add command to create a new project. When Momentum is in [task view](#glossary), you can use the add command to create a new task for the project that you are viewing.

Format: `add n/NAME [d/DESCRIPTION] [c/] [dd/DEADLINE_DATE [dt/DEADLINE_TIME]] [r/REMINDER_DATE_TIME] [t/TAG]`

* `n/NAME`

  * You can enter alphanumeric characters (a-Z, 0-9) and spaces for names. <br>

* `[d/DESCRIPTION]`

  * You can enter any character for descriptions.

  <div markdown="block" class="alert alert-info">

  :bulb: You can enter an empty description.

  </div>

* `[c/]`

  * The project/task added will be incomplete by default.

  * You can add a project/task with completion status complete by entering `c/`. <br>

* `[dd/DEADLINE_DATE [dt/DEADLINE_TIME]]`

  * Note that `dt/DEADLINE_TIME` is an optional part of the the `dd/`. You cannot enter a deadline with time only.

  * You can enter a deadline with date only.

  * You need to enter the date of the deadline using YYYY-MM-DD format. (refer to [Date Terms](#date-terms) for more information on YYYY, MM and DD)

  * You need to enter the time of the deadline using HH:MM:SS format in 24 hours. (refer to [Time Terms](#time-terms) for more information on HH, MM and SS)

  <div markdown="block" class="alert alert-danger">

  :warning: You cannot enter a date earlier than the creation date of the project/task for deadlines.

  </div>

* `[r/REMINDER_DATE_TIME]`

  * You need to enter both date and time for a reminder.

  * You need to enter date and time of the reminder using YYYY-MM-DDTHH:MM:SS format. (refer to [Date and Time Terms](#Date-and-Time-Terms) for more information on YYYY, MM, DD, HH, MM, and SS)

  <div markdown="block" class="alert alert-info">

  :bulb: `T` separates the date and time in a reminder.

  </div>

  <div markdown="block" class="alert alert-danger">

  :warning: You cannot enter a date and time earlier than the current date and time for reminders. (refer to [Reminders](#reminders) for more details on reminders)

  </div>

* `[t/TAG]`

  * Similar to names, you can enter alphanumeric characters (a-Z, 0-9) and spaces in tags.

  <div markdown="block" class="alert alert-info">

  :bulb: You can enter any number of tags, including 0.

  </div>

Example: `add n/Momentum d/CS2103T Team Project dd/2021-12-07 dt/11:01:12 r/2021-12-07T11:01:12 t/impt`

Result: Momentum will create a project/task named "Momentum", with description "CS2103T Team Project", deadline date "2020-10-07" as well as deadline time "11:01:12", reminder "2020-10-07T11:01:12", and tag "impt".

##### Walkthrough of Creating a Project

1. You can type `add n/Momentum d/CS2103T Team Project c/ dd/2021-12-07 dt/11:01:12 r/2021-12-07T11:01:12 t/impt` in the command box, and press the <kbd>Enter</kbd> key to execute it.
![Walkthrough of Creating a Project Diagram Step 1](images/AddProjectDiagram1.png)

2. The result box will display a message to indicate that you executed the command successfully.
![Walkthrough of Creating a Project Diagram Step 2](images/AddProjectDiagram2.png)

3. You added a project to the project list as shown below.
![Walkthrough of Creating a Project Diagram Step 3](images/AddProjectDiagram3.png)

4. On 7 December 2021, at 11:01:12, the reminder panel will show the reminder you added and the reminder of the project will be removed.
![Walkthrough of Creating a Project Diagram Step 4](images/AddProjectDiagram4.png)

#### Editing a Project/Task: `edit`

Done by Cheong Ying Yi Clara

When Momentum is in [project view](#glossary), you can use the edit command to edit a project. When Momentum is in [task view](#glossary), you can use the edit command to edit a task for the project that you are viewing.

Format: `edit ID [n/NAME] [d/DESCRIPTION] [c/] [dd/DEADLINE_DATE [dt/DEADLINE_TIME]] [r/REMINDER_DATE_TIME] [t/TAG]`

* You need to provide at least one of the optional fields.

* Your input will override the existing values of the project/task edited.

<div markdown="block" class="alert alert-info">

:bulb: You can remove a description, deadline or reminder by typing `d/` or `dd/` or `r/` without specifying anything after it.

</div>

* `ID`

  * You can refer to [`ID` Term](#id-term) for more information. <br>

* `n/NAME`

  * You can enter alphanumeric characters (a-Z, 0-9) and spaces for names. <br>

* `[d/DESCRIPTION]`

  * You can enter any character for descriptions. <br>

* `[c/]`

  * You can change the completion status of a project/task by entering `c/`.

  * If the project/task was incomplete, the completion status will change to complete.

* `[dd/DEADLINE_DATE [dt/DEADLINE_TIME]]`

  * Note that `dt/DEADLINE_TIME` is an optional part of the the `dd/`, you cannot enter a deadline with time only.

  * You can enter a deadline with date only.

  * You need to enter the date of the deadline using YYYY-MM-DD format. (refer to [Date Terms](#date-terms) for more information on YYYY, MM and DD)

  * You need to enter the time of the deadline using HH:MM:SS format in 24 hours. (refer to [Time Terms](#time-terms) for more information on HH, MM and SS)

* `[r/REMINDER_DATE_TIME]`

  * You need to enter both date and time for a reminder.

  * You need to enter date and time of the reminder using YYYY-MM-DDTHH:MM:SS format. (refer to [Date and Time Terms](#Date-and-Time-Terms) for more information on YYYY, MM, DD, HH, MM, and SS)

* `[t/TAG]`

  * Similar to names, you can enter alphanumeric characters (a-Z, 0-9) and spaces in tags.

  * Momentum will replace all the existing tags of the project/task with the new tags that you added.

  <div markdown="block" class="alert alert-info">

  :bulb: You can remove all the project’s tags by typing `t/` without specifying any tags after it.

  </div>

Example: `edit 3 n/NewMomentum d/NewDescription dd/2021-12-07 t/normal`

Result: Momentum will edit the third project/task. The name will be changed to "NewMomentum", the description will be changed to "NewDescription", the deadline will be changed to "2021-12-07", all the tags will be removed and a tag named normal will be added.

##### Walkthrough of Editing a Task

1. In task view, you can type `edit 3 n/NewMomentum d/NewDescription dd/2021-12-07 r/ t/normal` in the command box, and press the <kbd>Enter</kbd> key to execute it.
![Walkthrough of Editing a Task Diagram Step 1](images/EditTaskDiagram1.png)

2. The result box will display a message to indicate that you executed the command successfully.
![Walkthrough of Editing a Task Diagram Step 2](images/EditTaskDiagram2.png)

3. You edited a task in the task list as shown below.
![Walkthrough of Editing a Task Diagram Step 3](images/EditTaskDiagram3.png)

#### Deleting a Project/Task: `delete`

Done by Farrell Nah Jun Hao

Deletes a project or task in the list.

Format: `delete ID`

* Deletes the project or task at the specified `ID`.
* You can refer to [`ID` Term](#id-term) for more information.

Example: `delete 2`

Result: Deletes the second project or task in the list.

##### Walkthrough of deleting a project
Suppose you would like to delete the first project in the list

![Delete1](images/Delete1.png)

1. Type `delete 1` into the command box and press >kbd>Enter</kbd>

    ![Delete2](images/Delete2.png)
    
2. The results box will display a message to indicate that the project has been successfully deleted. You should no long see the project in the display list.

    ![Delete3](images/Delete3.png)

#### View All : `list`

Done by Farrell Nah Jun Hao

When you are viewing projects, this command shows you a list of all projects in Momentum.

When you are viewing a project's tasks, this command shows you a list of all the tasks for the project.

<div markdown="block" class="alert alert-info">

:bulb:
Note that this command is different from the `home` command. When viewing a project's tasks, the `home` command will change the view to show you all the projects being tracked by Momentum. However, the `list` will only show you all the tasks for the project.

</div>

Format: `list`

##### Walkthrough of viewing all projects
Suppose you ahd previously executed a [find command]() and would like to see all your projects again.

![List1](images/List1.png)

1. Type `list` into the command box and press <kbd>Enter</kbd>

    ![List2](images/List2.png)
    
2. The results box will display a message to indicate that all your projects are being displayed. You should see that all your projects are being displayed in the display list.

    ![List3](images/List3.png)

#### Sort Projects : `sort`

Done by Kang Su Min

This command allows you to sort the list of displayed projects or tasks in a particular sort type and order.

Format: `sort [type/SORT_TYPE] [order/SORT_ORDER] [c/]`

* There are 3 sort types.
  * `type/alpha` will sort the list of projects in alphabetical order.
  * `type/deadline` will sort the list of projects according to their deadlines.
  * `type/created` will sort the list of projects according to their date of creation.

* There are 2 sort orders.
  * `order/asc` will sort the list of projects in ascending order.
  * `order/dsc` will sort the list of projects in descending order.

In addition to the above sort types and orders, the list can be sorted by completion status.
* This is the "dominant sort" that will ensure that all incomplete projects/tasks are above complete projects/tasks, before sorting the projects/tasks in the specified sort type and order above.
* The default sort order will sort the projects/tasks by completion status.
* `sort c/` will toggle the default completion status sort.
    * Once the completion status sort is off, the projects/tasks will be sorted in the specified sort type and order without regard for their completion status.

<div markdown="block" class="alert alert-primary">

:bulb: 
* When the application first starts, the completion status order is on. This completion status sort status (on/off) is maintained until it is toggled.
* `type/alpha` and `order/asc` will be used as default if both sort type and order are not specified (i.e. command is `sort`)
* For both `sort type/deadline` and `sort type/created`, projects with the same deadline or same created date will be sorted in alphabetical order.
* For `sort type/deadline`, projects/tasks with deadlines will appear at the top of the list sorted in deadline order, while those without deadlines will be pushed to the end of the list sorted in alphabetical order

</div>

**Sorting by Default Order**

Format: `sort`

This sorts projects in default ascending alphabetical order.

The following walkthrough shows how you can sort projects in Momentum by the default order.

1. Key in command `sort` in the command window then press <kbd>Enter</kbd>.
![Default Sort Step 1](images/DefaultSort1.png)
2. The result box will display a message to indicate that the command has been executed successfully:
![Default Sort Step 2](images/DefaultSort2.png)
3. All projects are ordered in default ascending alphabetical order with incomplete tasks showing up at the top of the list (Completion status sort is on).
![Default Sort Step 3](images/DefaultSort3.png)

##### Sorting With Completion Status Toggle

Format: `sort c/`

This toggles the completion status order i.e. if the completion status order is "on", the completion status order is turned "off", vice versa.

The following walkthrough shows how you can toggle the completion status order in Momentum.

1. Key in command `sort c/` in the command window then press <kbd>Enter</kbd>.
![Toggle Completion Status Step 1](images/ToggleCompletionStatus1.png)
Note that currently all projects at the top of the list are incomplete tasks.
2. The result box will display a message to indicate that the command has been executed successfully:
![Toggle Completion Status Step 2](images/ToggleCompletionStatus2.png)
3. All projects are ordered in default ascending alphabetical order without regard for their completion status.
![Toggle Completion Status Step 3](images/ToggleCompletionStatus3.png)

##### Sorting with Only Type Specified

`order/asc` is assumed if the `order` is not specified.
Hence, this sorts projects by the specified sort type, in ascending order.

Format: `sort type/SORT_TYPE`

Example: `sort type/deadline`

The following walkthrough shows how you can sort projects in Momentum by specifying only the sort type.

1. Key in command `sort type/deadline` in the command window then press <kbd>Enter</kbd>.
![Deadline Sort 1](images/DeadlineSort1.png)
Note that the projects are not sorted in asceding deadline order.
2. The result box will display a message to indicate that the command has been executed successfully:
![Deadline Sort 2](images/DeadlineSort2.png)
3. All projects are ordered in ascending deadline order.
![Deadline Sort 3](images/DeadlineSort3.png)

##### Sorting With Only Order Specified

The current sort type is assumed if the `type` is not specified.
If there is no existing project order (when the application restarts), order will be alphabetical by default.

Format: `sort order/SORT_ORDER`

Example: `sort order/dsc`

The following walkthrough shows how you can sort projects in Momentum by specifying only the sort order.

1. Key in command `sort order/dsc` in the command window then press <kbd>Enter</kbd>.
![Deadline Sort Descending 1](images/DeadlineDescending1.png)
Note that currently the projects are sorted in ascending deadline order.
2. The result box will display a message to indicate that the command has been executed successfully:
![Deadline Sort Descending 2](images/DeadlineDescending2.png)
3. All projects are ordered in descending deadline order.
![Deadline Sort Descending 3](images/DeadlineDescending3.png)

##### Sorting With Both Type and Order Specified

This sorts projects in the specified type and order.

Example: `sort type/created order/dsc`

The following walkthrough shows how you can sort projects in Momentum by specifying both sort type and order.

1. Key in command `sort type/created order/dsc` in the command window then press <kbd>Enter</kbd>.
![Created Descending 1](images/CreatedDescending1.png)
Note that the projects are not sorted by descending created date order.
2. The result box will display a message to indicate that the command has been executed successfully:
![Created Descending 2](images/CreatedDescending2.png)
3. All projects are ordered in descending created date order.
![Created Descending 3](images/CreatedDescending3.png)
Note that for projects with the same created date, they are sorted in descending alphabetical order.

#### Filtering Projects: `find`

Done by Balasubramaniam Praveen

Searches for projects or tasks in the project book based on certain parameters.

Format: `find [match/FILTER_TYPE] [n/NAME [MORE_NAMES]...] [d/DESCRIPTION [MORE_DESCRIPTIONS]...] [t/TAG [MORE_TAGS]...] [c/COMPLETION_STATUS]`

* There are three values for the `match` parameter.
    * `match/all` shows an entry only if **all** of the parameters provided in the user's input matches the entry.
    * `match/any` shows an entry as long as **any** of the parameters provided in the user's input matches the entry.
    * `match/none` shows an entry only if **none** of the parameters provided in the user's input matches the entry.

<div markdown="block" class="alert alert-info">

:bulb: **Tip:**
You can only search for projects in the project view and tasks in the tasks view

</div>

<div markdown="block" class="alert alert-info">

:bulb: **Tip:**
`match/any` will be used if the `match` type is not specified.

</div>

<div markdown="block" class="alert alert-info">

:bulb: **Tip:**
Search parameters are not case sensitive.

</div>

##### Searching by Name

* The `n/` command checks whether a project has a certain name. There can be multiple names added to this command. For example, `n/car window` will check for the projects that contain `car` or `window` in their names.
* Searching by name only requires a partial match. This means that a project with the name `carpet` and `car` can potentially be the result of searching for the term `car`.

The following walkthrough shows how a user can use the find command to search for projects with the `ad` in their names.

1. Key in the command `find n/ad` in the command window.
![Find by Name Step 1](images/FindByName1.png)
2. The result box will display a message to indicate that the command has been executed successfully:
![Find by Name Step 2](images/FindByName2.png)
3. All projects that contain `ad` in their name will be shown.
![Find by Name Step 3](images/FindByName3.png)

##### Searching by Description

* The `d/` command checks whether a project has a certain description. There can be multiple descriptions added to this command. For example, `d/sunday october` will check for the projects that contain `sunday` or `october` in their description.
* Searching by description only requires a partial match, similar to searching by name.

The following walkthrough shows how a user can use the find command to search for projects with the `discussion` in their description.

1. Key in the command `find d/discussion` in the command window.
![Find by Description Step 1](images/FindByDescription1.png)
2. The result box will display a message to indicate that the command has been executed successfully:
![Find by Description Step 2](images/FindByDescription2.png)
3. All projects that contain `discussion` in their description will be shown.
![Find by Description Step 3](images/FindByDescription3.png)

##### Searching by Tag

* The `t/` command checks whether a project has a certain tag. There can be multiple tags added to this command. For example, `t/freelance errands` will check for the projects that contain the tags `freelance` or `errands`.
* Searching by tags will require a full word match unlike searching by name or description. This means that searching for the tag `free` will not find a project with the tag `freelance`.

<div markdown="block" class="alert alert-info">

:bulb: **Tip:**
Searches for tags require a full match whilst partial matches are sufficient for searches by name and description.

</div>

The following walkthrough shows how a user can use the find command to search for projects with the tag `webdesign`.

1. Key in the command `find t/webdesign` in the command window.
![Find by Tag Step 1](images/FindByTag1.png)
2. The result box will display a message to indicate that the command has been executed successfully:
![Find by Tag Step 2](images/FindByTag2.png)
3. All projects that contain the tag `webdesign` will be shown.
![Find by Tag Step 3](images/FindByTag3.png)

##### Searching by Completion Status

* There are keywords, completed and incomplete for`c/KEYWORD`. Other keywords are not accepted.
* The `c/` command checks whether a project is completed. For example, `c/completed` will check for the projects that are completed.
* When `c/` is not specified, both complete and incomplete projects will be shown.

The following walkthrough shows how a user can use the find command to search for projects that have been completed.

1. Key in the command `find c/completed` in the command window.
![Find by Completion Step 1](images/FindByCompletion1.png)
2. The result box will display a message to indicate that the command has been executed successfully:
![Find by Completion Step 2](images/FindByCompletion2.png)
3. All projects that are completed will be shown.
![Find by Completion Step 3](images/FindByCompletion3.png)

##### Searching with Multiple Parameters

You can search for projects/tasks with multiple keywords for names, descriptions and tags in a single search.

A match type can also be specified as mentioned at the [start of this section](#filtering-projects-find).

Please look at the examples below to get a better understanding of how you can make searches with multiple parameters.

Examples:

Let's say that you have the following projects in Momentum:

1. Name: `Create Logo` , Description: `Make logo for startup XYZ`, Tags: `Design`
2. Name: `Write Song`, Description: `80s rock music, three minutes`, Tags: `Music`
3. Name: `Write Article`, Description: `Write an article about why Momentum is the best app out there`, Tags: `Press` and `Writing`

* `find match/any n/song article d/startup t/design` will return all three projects. This is because project 1 contains the keyword `startup` in its description and the tag `design`, project 2 contains the keyword `song` in its name and project 3 contains the keyword `article` in its name.

* `find match/all n/song article d/startup t/design` will not return any project as there is no project with `song` **and** `article` in its name **and** `startup` in its description and the tag `design`.

* `find match/none n/song article d/startup t/design` will not return any project as there is no project that **does not** contain `song` and `article` in its name, `startup` in its description and the tag `design`.

* `find match/any n/write d/rock` will return projects 2 and 3. This is because project 2 contains `write` in its name and `rock` in its description. Project 3 also contains the word `write` in its name.

* `find match/all n/write d/rock` will only return project 2. This is because project 2 is the only project that contains both `write` in its name **and** `rock` in its description.

* `find match/none n/write d/rock` will return project 1. This is because only project 1 **does not** contain
 `write` in its name and `rock` in its descriptions.

<div markdown="block" class="alert alert-info">

:bulb: **Tip:**
If a certain search type is used more than once, the latest entry will be used.
`find n/a n/b n/c` will only search for projects/tasks that contain`c` in their name.

</div>

<div markdown="block" class="alert alert-info">

:bulb: **Tip:**
The projects/tasks in Momentum will no longer be filtered after the `Add`, `View` or `Home` Commands are used.
They will continue to be filtered after the `Edit` and `Delete` Commands are used.
</div>

### Time Tracking

Done by Farrell Nah Jun Hao

You can track the time you spend working on a project or task by starting a timer when you start working, and then stopping the timer once you finish.

Momentum remembers each timer that you start/stop and uses this information to calculate statistics.

#### Starting a Timer for a Project: `start`

Format: `start ID`

* Starts a timer for the project or task at the specified `ID`.
* Only 1 timer can be running for each project or task at any time.
* You can refer to [`ID` Term](#id-term) for more information.

<div markdown="block" class="alert alert-info">

:bulb:
You can run timers for more than one project or task concurrently, if you are multi-tasking.

</div>

<div markdown="block" class="alert alert-info">

:bulb:
You can run timers for a project separately from its tasks. This allows you to track the time you spent on the project as a whole, as well as the time spent on each individual task.

</div>

Example: `start 2`

Result: Starts a timer for the second project or task in the display list.

#### Stopping a Timer for a Project: `stop`

Format: `stop ID`

* Stops a running timer for the project or task at the specified `ID`.
* A timer can only be stopped if there is one already running.
* You can refer to [`ID` Term](#id-term) for more information.

Example: `stop 2`

Result: Stops the timer for the second project or task in the display list.

#### Active Timers Panel

On the left side of the window is the Active Timers Panel. This is where Momentum shows you all the timers that are currently running.

![ActiveTimersUI](images/ActiveTimersUI.png)
Figure X: Location of the Active Timers Panel.

This panel will show you the name of the project/task, as well as when the timer was started.

#### Time Tracking Example

Here is an example of how you can use the `start` and `stop` commands to track the time that you spend on a project.
Suppose that you are going to start working on the project "Alpharad Youtube Endcard", which is the first item shown below:

![TimerExample1](images/TimerExample1.png)

You can perform time tracking with the following steps:

1. To start the timer, type `start 1` into the command box and press <kbd>Enter</kbd>.

    ![TimerExample2](images/TimerExample2.png)

2. You should see the following message in the result box, indicating that the timer has been successfully started.

    ![TimerExample3](images/TimerExample3.png)

3. You should also see the project's name and start time in the active timers panel:

    ![TimerExample4](images/TimerExample4.png)

   Now that the timer has been successfully started, you can proceed to do your work. You can also choose to close
 Momentum. The timer will continue to run even when Momentum is closed. Proceed to the next step when you are done
  with your work.

4. To stop the timer, type `stop 1` into the command box and press `Enter`.

    ![TimerExample5](images/TimerExample5.png)

5. You should see the following message in the result box, indicating that the timer has been successfully stopped.

    ![TimerExample6](images/TimerExample6.png)

6. You should also see that the project has been removed from the active timers panel:

    ![TimerExample7](images/TimerExample7.png)

8. The statistics panel (see [statistics](#statistics)) will also be updated to reflect the time that you have spent
 working on the
 project:

    ![TimerExample8](images/TimerExample8.png)

### Reminders

Done by Cheong Ying Yi Clara

* A reminder will be shown in the reminder panel of the sidebar at the date and time you specified.

* Momentum will remove the reminder in the project/task after it is shown in the sidebar.

* If you missed a reminder, it will be greyed out in the project/task.

* You can refer to [Walkthrough of Creating a Project](#walkthrough-of-creating-a-project) for more details on how you can add a reminder.

* You can refer to [Walkthrough of Dismissing a Reminder](#walkthrough-of-dismissing-a-reminder) for more details on how you can dismiss a reminder.

<div markdown="block" class="alert alert-danger">

:warning: If you set multiple reminders at the same date and time, Momentum will only show one of the reminders in the reminder panel and mark other reminders as missed.

</div>

### Undo/Redo

Done By Kang Su Min

The undo/redo feature can be thought of as a "history traversal" function. After the execution of every command (excluding `help` and `exit`), all data at that point in time is stored in your Momentum history log.
The undo and redo command allows you to traverse up or down this history log such that you can recover any data that has been stored in your Momentum history at any point in time.  

#### Undoing the Previous Command: `undo`

The undo command undoes the last command that was executed. You can recover all data before the last command was executed.

Format: `undo`

Example: `start 1`, `undo`

Result: Timer for project/task at index 1 is started, then stopped and removed after `undo` is executed.

The following walkthrough shows how a user can start a timer for a project, then undo the command.

1. Key in command `start 1` in the command window then press <kbd>Enter</kbd>.
![Undo 1](images/Undo1.png)
2. The result box will display a message to indicate that the command has been executed successfully, and the timer for that project will appear at the side panel.
![Undo 2](images/Undo2.png)
3. Key in command `undo` in the command window then press <kbd>Enter</kbd>.
![Undo 3](images/Undo3.png)
4. The result box will display a message to indicate that the command has been undone successfully.
![Undo 4](images/Undo4.png)
5. The timer has been removed from the project. Timer is no longer running.
![Undo 5](images/Undo5.png)

#### Redoing the Previous Command: `redo`

The redo command redoes the last command that was previously undone. You can recover all data before the last `undo` command was executed.

Format: `redo`

Example: `sort type/deadline`, `undo`, `redo`

Result: Projects are first sorted by deadline, then the application is reset to the sorting order before sort command was executed when `undo` command is executed, then reset back to sort by deadline after `redo` command.

The following walkthrough shows how a user can start a timer for a project, then undo the command.

1. Key in command `sort type/deadline` in the command window then press <kbd>Enter</kbd>.
![Redo 1](images/Redo1.png)
Note: The projects are currently sorted in alphabetical, ascending order (default order).
2. The result box will display a message to indicate that the command has been executed successfully. Projects are now sorted in ascending deadline order.
![Redo 2](images/Redo2.png)
3. Key in command `undo` in the command window then press <kbd>Enter</kbd>.
![Redo 3](images/Redo3.png)
4. The result box will display a message to indicate that the command has been undone successfully. Projects are now sorted in their original order (alphabetical, ascending).
![Redo 4](images/Redo4.png)
5. Key in command `redo` in the command window then press <kbd>Enter</kbd>.
![Redo 5](images/Redo5.png)
6. The result box will display a message to indicate that the command has been redone successfully.
![Redo 6](images/Redo6.png)
7. Projects are again sorted in ascending deadline order.
![Redo 7](images/Redo7.png)

<div markdown="block" class="alert alert-primary">

:bulb:
* Undo/redo feature keeps track of changes in data, and hence will not work on `help` or `exit` command which do not change the data in the application.
* Redo command only works if the previous command is `undo`.

</div>

### Statistics

Done by Farrell Nah Jun Hao

Momentum uses the data collected from your timers (see [time tracking](#time-tracking)) to calculate statistics. These
 statistics are automatically generated and updated whenever you make any changes to your projects and tasks, such as
  when you start or stop a new timer.
 These statistics can be seen in a panel on the left side of the window, as shown here:

![StatisticsUI1](images/StatsUI1.png)
Figure X: Location of the statistics panel

The statistics displayed correspond to the projects or tasks currently shown in the display list, and will automatically
 change when the items in the display list changes (such as when you find specific projects or sort the list of projects).

![StatisticsUI2](images/StatsUI2.png)
Figure X: The order of the statistics entries matches the order in the display list.

You do not need to use any additional commands to update or view the statistics.

#### Timeframes

Momentum only tracks your statistics within a particular timeframe. You can change the timeframe through the [settings](#settings).

Momentum allows you to track the time spent within these timeframes:

* Daily
* Weekly
* Monthly

By default, the timeframe will be set to weekly.

Here are the statistics being tracked by Momentum:

#### Time Spent Per Project

This statistic tells you the total amount of time you have spent within the timeframe. For projects, this includes
 all the time you have spent on each individual task, as well as on the project as a whole.

![StatsUISplit](images/StatsUISplit.png)
Figure X: Sections of the statistics panel.

The statistics are displayed in 2 different formats:

1. **Pie Chart**: Shows the relative time spent on each project. Useful for comparing different projects and tasks. Projects
 and tasks with less time spent on them may not be shown.
2. **Table**: Shows the exact (in minutes) amount of time spent on each project. Useful for calculations.

### Settings

Done by Khoo De Hui

You can adjust various settings in Momentum, which includes:
* GUI Theme
* Statistics Timeframe

Format: `set [th/THEME] [st/TIMEFRAME]`
* At least one of the optional fields must be provided.
* There are two GUI themes available, light and dark. The keywords to apply them are:
  * `th/light`
  * `th/dark`
* There are three available timeframes for statistics, daily, weekly and monthly. The keywords to apply them are:
  * `st/daily`
  * `st/weekly`
  * `st/monthly`

Example: `set th/light st/monthly`

Result: Sets a dark theme to the GUI and changes the statistics pane to show the time spent on projects within the day.

#### Walkthrough of Changing Application Settings
1. In order to set the GUI theme to light and the statistic timeframe to daily, enter `set th/light th/monthly` in the command box and press the `Enter` key to execute it.
 ![Settings Walkthrough Step 1](images/SettingsDiagram1.png)
2. The result box will display a message to indicate that the command has been executed successfully.
 ![Settings Walkthrough Step 2](images/SettingsDiagram2.png)
3. The GUI theme has now been set to the light theme, and information in the statistics panel has been updated.
 ![Settings Walkthrough Step 3](images/SettingsDiagram3.png)

### Clear All Projects/Tasks : `clear`

Done by Farrell Nah Jun Hao

When you are viewing all projects, this command deletes all the projects in Momentum, including their tasks.

When you are viewing a specific project's tasks, this command will delete all the tasks in the project. The project
 itself will not be deleted.

<div markdown="block" class="alert alert-danger">
:warning:
This command will also delete the saved data.
You can undo this operation while Momentum remains open.
However, you will not be able to undo this once you close Momentum.

Please be careful when using this command, as you may loose large amounts of your data.

</div>

Format: `clear`

#### Walkthrough of clearing Projects
Suppose that you would like to clear all the projects in Momentum.

1. Ensure that you are viewing all projects

    ![ClearProject0](images/ClearProject0.png)
    
2. Type `clear` into the command box and press <kbd>Enter</kbd>
    
    ![ClearProject1](images/ClearProject1.png)

3. The result box will display a message to indicate that all projects have been cleared. You should no long see any projects in the display list.

    ![ClearProject2](images/ClearProject2.png)

### Dismissing a Reminder : `dismiss`

Done by Cheong Ying Yi Clara

You can dismiss a reminder using this command.

Format: `dismiss`

Result: The reminder panel of the sidebar will be hidden.

<div markdown="block" class="alert alert-danger">

:warning: You cannot dismiss a reminder if the reminder panel of the sidebar is not visible.

</div>

<div markdown="block" class="alert alert-danger">

:warning: Momentum cannot show a reminder that you dismissed in the reminder panel again. You can undo a dismissal to show an expired reminder in the project/task.

</div>

#### Walkthrough of Dismissing a Reminder

This walkthrough is a followup of [Walkthrough of Creating a Project](#walkthrough-of-creating-a-project).

1. After the reminder panel is shown, you can type `dismiss` in the command box, and press the <kbd>Enter</kbd> key to execute it.
![Walkthrough of Dismissing a Reminder Step 1](images/DismissDiagram1.png)

2. The result box will display a message to indicate that that you executed the command successfully.
![Walkthrough of Dismissing a Reminder Step 2](images/DismissDiagram2.png)

3. You dimissed the reminder as shown below.
![Walkthrough of Dismissing a Reminder Step 3](images/DismissDiagram3.png)

### Showing and Hiding Tags : `show`

Done by Cheong Ying Yi Clara

You can hide or show the tags panel of the sidebar.

Format: `show t/`

Result:

* If the tags panel was visible, the tags panel will be hidden.

* If the tags panel was hidden, the tags panel will be shown.

<div markdown="block" class="alert alert-info">

:bulb: You can resize the tags panel by clicking and dragging the edges.

</div>

#### Walkthrough of Hiding Tags

1. You can type `show t/` in the command box, and press the <kbd>Enter</kbd> key to execute it.
![Walkthrough of Hiding Tags Step 1](images/ShowDiagram1.png)

2. The result box will display a message to indicate that you executed the command successfully.
![Walkthrough of Hiding Tags Step 2](images/ShowDiagram2.png)

1. You hide the tags panel as shown below.
![Walkthrough of Hiding Tags Step 3](images/ShowDiagram3.png)

### Viewing Help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

### Exiting the Program : `exit`

All project, task and timer data are saved automatically after every command. There is no need to save manually.

You can find the saved data in the following file in the same location where Momentum is located: `data/projectbook.json`

Format: `exit`

Result: Exits the program.

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer? <br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous Momentum home folder.

**Q**: Momentum is showing "Dates and Times should be in ISO8601 format. e.g. 2020-09-23T16:55:12". Whats wrong? <br>
**A**: You have entered a date and/or time in the wrong format. Please refer to the [date and time terms](#date-and-time-terms) for the correct format to use.

**Q**: Momentum showing "Unknown Command". Whats wrong? <br>
**A**: You have entered a command that is not recognised by Momentum. Please refer to [command summary](#command-summary) for a list of commands that you can enter into Momentum.

--------------------------------------------------------------------------------------------------------------------

## Glossary

* **Command Line Interface(CLI)**: Command Line Interface processes commands in the form of text
* **Mainstream OS**: Windows, Linux, Unix, OS-X
* **Window**: The area of your computer's screen that displays the [user interface](#user-interface-overview) of Momentum
* **Project View**: View all projects in the project book.
* **Task View**: View all tasks that are added to a single project.

--------------------------------------------------------------------------------------------------------------------

## Command Summary

Action | Format | Example
--------|-------|-----------
**View tasks in a project**| `view ID` |`view 3`
**View all projects**| `home` | -
**Creating a Project/Task** | `add n/NAME [d/DESCRIPTION] [c/] [dd/DEADLINE_DATE [dt/DEADLINE_TIME]] [r/REMINDER_DATE_TIME] [t/TAG]​`|  `project n/Momentum d/CS2103T Team Project dd/2021-12-07 t/impt`
**Editing a Project/Task** | `edit ID [n/NAME] [d/DESCRIPTION] [c/]  [dd/DEADLINE_DATE [dt/DEADLINE_TIME]] [r/REMINDER_DATE_TIME] [t/TAG]`| `edit 3 n/NewMomentum d/NewDescription dd/2021-12-07 r/2021-12-07T01:21:21 t/normal`
**Delete a project/task** | `delete ID` | `delete 3`
**Clear all projects/tasks** | `clear` | -
**Find a project/task** | `find [match/FILTER_TYPE] [n/NAME [MORE_NAMES]...] [d/DESCRIPTION [MORE_DESCRIPTIONS]...] [t/TAG [MORE_TAGS]...]  [c/COMPLETION_STATUS]`  | `find match/any n/Momentum d/new t/normal`
**Show all projects/tasks (after find)** | `list` | `list`
**Sort projects/tasks** | `sort [type/SORT_TYPE] [order/SORT_ORDER] [c/]` | `sort type/deadline order/dsc c/`
**Start Timer** | `start ID` | `start 2`
**Stop Timer** | `stop ID` | `stop 2`
**Dismissing a Reminder** | `dismiss` | -
**Showing and Hiding Tags** | `show t/` | -
**Undo** | `undo` | -
**Redo** | `redo` | -
**Help** | `help` | -
**Settings** | `set [th/THEME] [st/TIMEFRAME]` | `set th/dark st/daily`
**Exit** | `exit` | -
