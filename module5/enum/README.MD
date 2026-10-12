An `enum` (short for enumeration) is a special data type in Java used to define a fixed set of constant values.

Think of it like a multiple-choice question on a test: instead of letting anyone type in any random answer, an `enum` limits the choices to a pre-approved list.

Enums are used everywhere in Java development when you have a variable that can only take one of a few known, unchanging values. Common use cases include:

- **Status Tracking:** Representing order statuses in an online shop (e.g., PENDING, PROCESSING, SHIPPED, DELIVERED).

- **Calendar & Time:** Representing days of the week (MONDAY through SUNDAY) or months of the year.

- **Directions:** Representing compass points (NORTH, SOUTH, EAST, WEST).

- **App Configurations:** Defining user roles (ADMIN, MODERATOR, GUEST) or theme settings (LIGHT_MODE, DARK_MODE).

- **Switch Statements:** Enums work wonderfully inside switch blocks to safely handle different paths based on the constant value.
