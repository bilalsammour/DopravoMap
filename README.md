# Dopravo Map #

Dopravo Map is a software engineering challenge for [Dopravo] company. The project is a dynamic Google map app with detail view, that shows stores on the map then the detailed info about the chosen store.


App Features
===========

- Showing random store on the Google map.
- Each store has a marker (anchor) on the map.
- Clicking on the marker will show the store detailed info.
- Clicking on the marker will show the other branches if the store has other branches.
- Clicking on a branch will navigate to the chosen branch on the map.
- Clicking anywhere on the map will hide the detailed view.


Code Structure
==============

The project has just one activity, `MainActivity` that has two fragments:

- `StoresMapFragment` that contains the Google map and shows the markers.
- `PlaceInfoFragment` that shows detailed info about the chosen place.

`MainActivity` does not deal with the fragments' methods, it deals with the interfaces that each fragment implements.

- `StoresMapFragment` implements `IPlaceInfoProtocol`.
- `PlaceInfoFragment` implements `IMapProtocol`.

So, `MainActivity` does not care if `PlaceInfoFragment` for example is a fragment or a custom view, `MainActivity` just needs the methods in `IMapProtocol` interface.

`PlacesLoader` is a very important class as well, it loads the places from a local file then returns a list object. `PlacesLoader` implements `IPlacesLoaderProtocol` interface, so no-one cares about `PlacesLoader` methods and variables.

For parsing text to JSON, [GSON] library is used. All parsing is through the utility class `JsonParser`.


Code Comments
============

Based on the book of [Clean Code] by Robert C. Martin:

- The proper use of comments is to compensate for our failure to express ourselves in code.
- Comments are always failures.
- We must have them because we cannot always figure out how to express ourselves without them, but their use is not a cause for celebration.

So, the code is clean of comments. Every class, method, variable, and constant figures out themselves by good naming, placing, and structure.


Design
=====

The project is a software engineering challenge, so, a simple material design is used.


License
----

MIT


**Free Software!**




[Dopravo]: <https://www.dopravo.com>
[GSON]: <https://github.com/google/gson>
[Clean Code]: <https://www.goodreads.com/book/show/3735293-clean-code>