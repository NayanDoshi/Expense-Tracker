# Expense-Tracker

The Expense Tracker Application is a comprehensive
solution designed to help users manage their finances
efficiently by tracking expenses across different
categories.

* Primary Functionality
1. Category Management
2. Expense Management
3. Exception Handling

1 - Category Management
Category Management feature allows Users to create new categories, update
existing ones, retrieve details about a specific category or all categories, and delete
categories. This functionality allows for effective categorization of expenses,
facilitating better budget management and financial planning.
Build CRUD REST APIs:
1. Create Category: Users can add new category.
2. Get Category: Users can retrieve details of a specific category.
3. Get All Categories: Users can retrieve a lists all available categories.
4. Update Category: Users can update the existing category.
5. Delete Category: Users can delete the existing category. 

2 - Expense Management
Expense Management feature allows Users to add new expenses, modify details of
existing expenses, view information about a particular expense or all expenses, and
remove expenses from the record. This feature is crucial for tracking daily expenses
and monitoring financial outflows.
Build CRUD REST APIs:
1. Create Expense: Users can add new expense under a specific category.
2. Get Expense: Users can retrieve details of a specific expense.
3. Get All Expenses: Users can retrieve a lists all available expenses.
4. Update Expense: Users can update the existing expense.
5. Delete Category: Users can delete the existing expense. 

3 - Exception Handling
The REST APIs should return the proper error
response as like For Category it should return message like : "Category not founf with id : 1" 
and for Expense - "Expense not found with id : 1"