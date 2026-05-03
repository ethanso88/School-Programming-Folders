package Application;
import Controller.MainNanoDatabaseController;

/*
name: ethan so

date: 6/13/2025

course code: ics4u1-03 mr. fernandes

title: nanoscale material database application for the fsp

description:
this app is a search database to quickly find and filter through popular industrial nanotechnology products.
users can view, search, and filter a list of nanomaterials by material type, company, and other properties.
the GUI lets you use checkboxes, sliders, and buttons to filter data.
you can also use the search bar or quick filter links to directly search stuff.
everything updates live as you change filters.
the goal is to make it easy to compare and explore different nanomaterials used in the industry.

features:
- a logo
- dynamically updating list of materials
- filters to sort by material type, subtype, and other properties
- quantity filters to sort by numerical values (like diameter, thickness, atoms, emission peak)
- sliders to set min/max values for quantity filters
- predetermined material search links (quick filter buttons)
- search bar to find materials by name or company
- help and exit buttons for user navigation
- modern, user-friendly gui

major skills demonstrated:
- methods and modular code
- mvc (model-view-controller) design pattern
- inheritance and polymorphism
- file input and data parsing
- gui design with java swing
- action listeners and event-driven programming
- sorting and filtering algorithms
- use of arraylists and custom classes
- error catching

Areas of Concern:
Hi Mr. Fernandes unfortunately the Other Filters category doesn't seem to be working even after debugging
The filter also definitely works when you search for or click a specific material category but it cannot change.
- I tried fixing it and it was working but then after some changes today it didn't work again and then I was stuck
This definitely wasn't my best project but I ran into a lot of issues
- a concern is also that I can only seem to get absolute file paths to work no matter how hard I try so sorry you will have to change that
- I also realized that some of the items in the files uses commas so I had to change it from .csv to .tsv
- The materials I researched had data that was way off so I had to change my filters and approach to be more realistic (like you said in class)
I appreciate your time and feedback, and I hope my work is helpful despite the difficulties. Good luck with the rest of your marking Mr. Fernandes
 */

//this is the main entry point for the nanomaterial database app
public class NanoMaterialDatabaseApplication {

    public static void main(String[] args) {
        new MainNanoDatabaseController();
    }

}
