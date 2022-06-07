# Test_1
## Problem
The program solves the problem of calculating the number of unique IP addresses in a text file.
## Solution
There are two main issues:
1. Storage of processed IPs
2. Fast parsing strings with IP
### Storage
For store processed IP used the BitSet. Each element is "packed" representation of an IP.
Each field of IP can be stored in 1 octet. The whole range of IPs can be stored in 2 BitSet:
low - for range from 0x0 to 0x7fffffff, high - more than 0x7fffffff and less 0xffffff.
Address - 0xffffffff handling separately, because highest bit in the high octet will be the 1 -  negative marker in four-bytes integer.
### Parsing
Fast parsing based on the code table for char. We know the offset for '0' symbol and can fast calculate a digit from his character.
Digital representation of the IP field is shifted to the corresponding octet. At the end we have "packed" IP.
For each IP, the status is checked in the corresponding BitSet, if state is false, we count IP and change status.
## Usage
The class Solution has the entry point "main", first argument is the full path to text file with IPs