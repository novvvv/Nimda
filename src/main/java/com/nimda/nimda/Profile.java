package com.nimda.nimda;

public class Profile {
    public static String getTierColor(int tier) {
        switch (tier) {
            case 1: return "#FFD700"; // Gold
            case 2: return "#C0C0C0"; // Silver
            case 3: return "#CD7F32"; // Bronze
            default: return "#007BFF"; // Default color
        }
    }

    public static int getTierNumber(int tier) {
        return tier; // Example, you can modify this logic as needed
    }
}

