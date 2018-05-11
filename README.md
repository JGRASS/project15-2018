# project15-2018

# SISTEM ZA KAFIC / COFFEE SHOP SYSTEM

A system for coffee shop used to manage orders and generating report at the end of a work-session of an employee.


User guide:

At the login page the user must enter username and password of an employee whose shift is starting. If the entered username belongs to an admin user, a different window will be opened.

example for a regular user: </br>
username: nikola.vujic </br>
password: lozinka </br>

if the user wants to access the admin page: </br>
username: rambo </br>
password: 123123 </br>

In the main window (if a regular user logged in) there are tables on which the user can click in order to select them. Pressing the Novi Racun dugme a new windows opens in which the user can choose articles that will be place on a receipt connected with the selected table. After adding a receipt, on the main page the user can see that a red colored receipt has been added to a list of receipts. By clicking on a red receipt, a new window appears where the user can process the receipt by adding the amount paid. If the amount entered is bigger than the total value of the recipt the user may finish processing the receipt. When a receipt has been successfully processed it will turn green and no longer be clickable. Pressing on the Kraj Rada button the user gets a preview of the report generated based on the receipts, clicking on the Zavrsi button the user gets logged out and the report gets saved in plain-text format. The user may not click on Kraj Rada button if there are no processed receipts. Clicking on the Logout button the user may log out without saving the receipts.

In the Admin window there are options to add or remove an employee and options to add or remove an article. Clicking on either remove options (Obrisi ...) a list of employees or articles will appear, choosing one will open a window displaying employee or article info with a confirmation for deletion.

Note: the database is dynamic, which means after adding a new employee or article the admin does not need to close the program in order for the database to be updated.
