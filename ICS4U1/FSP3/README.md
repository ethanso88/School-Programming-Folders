# Nanomaterial Database Application

Grade 12 Computer Science (ICS4U) final summative project, June 2025. A Java Swing desktop app
that loads 1,521 nanomaterials of 7 types (nanotubes, nanoparticles, nanofibers, nanowires,
graphene, fullerenes, quantum dots) from the 10 supplier datasheets in `Data/` and filters them
live: by type, by name or company in the search bar, or by diameter, thickness, atom count or
emission peak on min/max sliders.

`FSP/` and `FSP2/` next to this folder are earlier snapshots of the same project. This one is the
final version and the one to run.

## Run it in VS Code

1. Clone the repo and open **this folder** (`ICS4U1/FSP3`) with File > Open Folder.
2. Install the **Extension Pack for Java** if VS Code offers it.
3. Open `src/Application/NanoMaterialDatabaseApplication.java` and click **Run** above `main`,
   or press F5 (the launch config is in `.vscode/launch.json`).

## Run it from a terminal

From inside this folder, with a JDK (17 or newer; the code uses `instanceof` patterns) on the PATH:

Windows PowerShell:

```
javac -d bin (Get-ChildItem -Recurse -Filter *.java src | ForEach-Object FullName)
java -cp bin Application.NanoMaterialDatabaseApplication
```

macOS / Linux:

```
javac -d bin $(find src -name '*.java')
java -cp bin Application.NanoMaterialDatabaseApplication
```

## How it finds its files

`src/Util/ProjectPaths.java` locates this folder (the one holding `Data/` and `Icons/`) by walking
up from the compiled classes, then from the working directory, so the app runs from any clone
location and any working directory. If it cannot find them it says so; you can also point it
with `java -Dnmda.root=<path to this folder> ...`.

## Layout

- `src/Model/` - abstract `Material` and its 7 subclasses
- `src/View/` - the title screen and the search screen (Swing)
- `src/Controller/` - datasheet loading, filtering and the event wiring
- `src/Util/` - the path helper above
- `Data/` - the datasheets (TSV is what the app reads; CSV copies kept beside them)
- `Icons/` - the logo and the 7 material icons
