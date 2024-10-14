

public static void main (String[] args) {
    // Create an instance of StringProcessor
    StringProcessor sp = new StringProcessor();

    // Test cases for isStrongPassword
    System.out.println("Testing isStrongPassword:");
    System.out.println("Is 'Strong1!' a strong password? " + sp.isStrongPassword("Strong1!")); // true
    System.out.println("Is 'weakpassword' a strong password? " + sp.isStrongPassword("weakpassword")); // false
    System.out.println("Is 'WEAKPASSWORD1' a strong password? " + sp.isStrongPassword("WEAKPASSWORD1")); // false
    System.out.println("Is 'Weak1!' a strong password? " + sp.isStrongPassword("Weak1!")); // false
    System.out.println("Is 'Str0ng!' a strong password? " + sp.isStrongPassword("Str0ng!")); // false

    // Test cases for calculateDigits
    System.out.println("\nTesting calculateDigits:");
    System.out.println("Digits in 'There are 3 apples and 2 bananas.': " + sp.calculateDigits("There are 3 apples and 2 bananas.")); // 2
    System.out.println("Digits in 'No digits here!': " + sp.calculateDigits("No digits here!")); // 0
    System.out.println("Digits in '12345': " + sp.calculateDigits("12345")); // 5
    System.out.println("Digits in 'One digit: 7.': " + sp.calculateDigits("One digit: 7.")); // 1
    System.out.println("Digits in 'Test 1, 2, 3, 4, 5, 6!': " + sp.calculateDigits("Test 1, 2, 3, 4, 5, 6!")); // 6

    // Test cases for calculateWords
    System.out.println("\nTesting calculateWords:");
    System.out.println("Words in 'This is a test sentence.': " + sp.calculateWords("This is a test sentence.")); // 6
    System.out.println("Words in '   ': " + sp.calculateWords("   ")); // 0
    System.out.println("Words in 'Hello  world! ': " + sp.calculateWords("Hello  world! ")); // 2
    System.out.println("Words in '  This  is  a   test.  ': " + sp.calculateWords("  This  is  a   test.  ")); // 5
    System.out.println("Words in 'Word': " + sp.calculateWords("Word")); // 1

    // Test cases for calculateExpression
    System.out.println("\nTesting calculateExpression:");
    System.out.println("Result of '3 + 4': " + sp.calculateWords("3 + 4")); // 7.0
    System.out.println("Result of '5 * 3': " + sp.calculateWords("5 * 3")); // 15.0
    System.out.println("Result of '10 / 5': " + sp.calculateWords("10 / 5")); // 2.0
    System.out.println("Result of '(4 + 4)': " + sp.calculateWords("(4 + 4)")); // 8.0
    System.out.println("Result of '5 + 5 + 2': " + sp.calculateWords("5 + 5 + 2")); // 12.0
}
