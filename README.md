# File Allocation Table Simulation  
### *By Richard Phan*

## Description
This Java project simulates a simplified **File Allocation Table (FAT)** using an array of `Block` objects. Each block stores two pieces of information:  
- **Data value** (an unsigned integer)  
- **Next index** (representing the link to the next block in the file)

Together, these form a **linked list inside an array**, allowing the user to build, traverse, and modify a simulated file structure. The program uses a menu-driven interface to perform operations such as adding blocks, removing blocks, and printing the table and file contents.

## File Allocation Summary
A File Allocation Table maps a file into a sequence of blocks. Each block may:
- store user data  
- point to the next block in the file  
- or be unused

This project models:
- **0** as an empty data field  
- **–1** as a null link (end of file)

`Block.java` is a pre-written, unmodified class required for storing block information.

## Features

### 1. **Print the table and the file**
Displays:
- A full table view of every block (index, data, next index)  
- A file view tracing the linked structure starting from `headIndex`  

This allows the user to visualize both the raw array and the actual file chain.

### 2. **Add a block to the file**
Users may:
- Enter an index where the new block will be stored  
- Enter an unsigned integer to store in that block  

The program validates:
- Input type  
- Index bounds  
- Duplicate block insertion  
- Negative data values  

New blocks are appended at the end of the current file chain unless the file is empty.

### 3. **Remove a block from the file**
Allows removing any block currently in the chain.  
Handles cases such as:
- Removing the head block  
- Removing blocks in the middle or end  
- Attempting to remove a block not in the file  

After removal, the block is reset to its empty state.

### 4. **Quit the program**
Ends execution cleanly and prints a farewell message.

## Class Structure

### `Project3.java`
- **Global Variables**  
  - `Scanner input` — user input  
  - `Block[] table` — file allocation table  
  - `int headIndex` — entry point to the file  
- **Core Methods**  
  - `printTableAndFile()`  
  - `addBlock()`  
  - `removeBlock()`  
  - `main()`  

### `Block.java`
A required object class containing:
- `data`  
- `nextIndex`  
- Getter/setter methods  

**This file must not be modified.**

## Run Instructions
1. Download the files:
   - `Project3.java`  
   - `Block.java`
2. Compile and run in your preferred Java environment (Eclipse, VS Code, jGRASP, or terminal).  
3. Follow the on-screen menu to interact with the file simulation.
