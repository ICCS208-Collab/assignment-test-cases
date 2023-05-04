import random
import sys


number_of_test_cases = 100
randomlist = []
func_name = "minMaxAverage"

# print('This message will be displayed on the screen.')

original_stdout = sys.stdout # Save a reference to the original standard output

with open('testcases.txt', 'w') as f:
  sys.stdout = f # Change the standard output to the file we created.
  
  for i in range(0, number_of_test_cases):
    for j in range(0, random.randint(1, 20)):
      n = random.randint(1, 100)
      randomlist.append(n)
      average = ((min(randomlist) + max(randomlist)) / 2.0)
    print(f"if ({func_name}(", end='')
    print("new int[]{", end='')
    print(*randomlist, sep=', ', end='')
    print("}", end='')
    print(")", end='')
    print(f" != {average}) throw new AssertionError();", end='')
    print("")
    randomlist = list()
    
  sys.stdout = original_stdout # Reset the standard output to its original value