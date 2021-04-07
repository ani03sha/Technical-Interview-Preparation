"""
@author Anirudh Sharma

Write a function "runCustomerSimulation" that takes following two inputs
a) An integer 'n': total number of computers in a cafe and a string:
b) A sequence of uppercase letters ‘seq’: Letters in the sequence occur in pairs.
The first occurrence indicates the arrival of a customer;
the second indicates the departure of that same customer.

A customer will be serviced if there is an unoccupied computer.
No letter will occur more than two times.

Customers who leave without using a computer always depart before customers who are
currently using the computers. There are at most 20 computers per cafe.

For each set of input the function should output a number telling how many customers,
if any walked away without using a computer.

Return 0 if all the customers were able to use a computer.
"""


def runSimulation(n, sequence):
    # Array to represents the states of a customer
    # customerStates[i] = 0 = > customer i is not in cafe
    # customerStates[i] = 1 > customer i is in but with no computer
    # customerStates[i] = 2 = > customer i is in cafe with computer
    customerStates = [0] * 26
    # Number of customers who won't get a computer
    customerCount = 0
    # Track of occupied computers
    occupiedComputerCount = 0
    # Loop through the sequence
    for c in sequence:
        # Index of the current character
        index = ord(c) - ord('A')
        # If the customer is first time in the cafe
        if customerStates[index] == 0:
            # Change its state
            customerStates[index] = 1
            # If the computer can be occupied
            if occupiedComputerCount < n:
                # Give the computer to the customer
                customerStates[index] = 2
                occupiedComputerCount += 1
            else:
                # Since the computer can't be assigned
                customerCount += 1
        # If the customer is already in the cafe
        else:
            if customerStates[index] == 2:
                occupiedComputerCount -= 1
            customerStates[index] = 0
    return customerCount


if __name__ == "__main__":
    print(runSimulation(2, "ABBAJJKZKZ"))
    print(runSimulation(3, "GACCBDDBAGEE"))
    print(runSimulation(3, "GACCBGDDBAEE"))
    print(runSimulation(1, "ABCBCA"))
    print(runSimulation(1, "ABCBCADEED"))
