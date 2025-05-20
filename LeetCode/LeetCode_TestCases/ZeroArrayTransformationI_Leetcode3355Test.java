package LeetCode_TestCases;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test class for ZeroArrayTransformationI_Leetcode3355
 * Tests different scenarios for the isZeroArray method
 */

public class ZeroArrayTransformationI_Leetcode3355Test {

    @Test
    @DisplayName("Should return true for array [1,0,1] with query transforming all elements to zero")
    void testIsZeroArray_SingleQuery_Success() {
        // Arrange
        int[] nums = { 1, 0, 1 };
        int[][] queries = { { 0, 2 } };

        // Act
        boolean result = ZeroArrayTransformationI_Leetcode3355.isZeroArray(nums, queries);

        // Assert
        assertTrue(result, "Array should be transformed to all zeros after applying the query");
    }

    @Test
    @DisplayName("Should return true for array [4,3,2,1] with multiple queries transforming all elements to zero")
    void testIsZeroArray_MultipleQueries_Success() {
        // Arrange
        int[] nums = { 4, 3, 2, 1 };
        int[][] queries = { { 1, 3 }, { 0, 2 } };

        // Act
        boolean result = ZeroArrayTransformationI_Leetcode3355.isZeroArray(nums, queries);

        // Assert
        assertTrue(result, "Array should be transformed to all zeros after applying all queries");
    }

    @Test
    @DisplayName("Should return false when queries cannot transform array to all zeros")
    void testIsZeroArray_ImpossibleTransformation() {
        // Arrange
        int[] nums = { 1, 2, 3 };
        int[][] queries = { { 0, 1 } };

        // Act
        boolean result = ZeroArrayTransformationI_Leetcode3355.isZeroArray(nums, queries);

        // Assert
        assertFalse(result, "Array cannot be transformed to all zeros with given queries");
    }

    @Test
    @DisplayName("Should handle empty array correctly")
    void testIsZeroArray_EmptyArray() {
        // Arrange
        int[] nums = {};
        int[][] queries = {};

        // Act
        boolean result = ZeroArrayTransformationI_Leetcode3355.isZeroArray(nums, queries);

        // Assert
        assertTrue(result, "Empty array should be considered as having all zeros");
    }
}
