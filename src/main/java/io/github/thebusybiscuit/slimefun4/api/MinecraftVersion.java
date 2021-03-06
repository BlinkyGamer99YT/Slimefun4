package io.github.thebusybiscuit.slimefun4.api;

import me.mrCookieSlime.Slimefun.SlimefunPlugin;

/**
 * This enum holds all versions of Minecraft that we currently support.
 * 
 * @author TheBusyBiscuit
 * 
 * @see SlimefunPlugin
 *
 */
public enum MinecraftVersion {

    /**
     * This constant represents Minecraft (Java Edition) Version 1.14
     * (The "Village &amp; Pillage" Update)
     */
    MINECRAFT_1_14("1.14.x"),

    /**
     * This constant represents Minecraft (Java Edition) Version 1.15
     * (The "Buzzy Bees" Update)
     */
    MINECRAFT_1_15("1.15.x"),

    /**
     * This constant represents an exceptional state in which we were unable
     * to identify the Minecraft Version we are using
     */
    UNKNOWN("Unknown");

    private final String name;
    private final String prefix;

    MinecraftVersion(String name) {
        this.name = name;
        this.prefix = name().replace("MINECRAFT_", "v") + '_';
    }

    /**
     * This returns the name of this {@link MinecraftVersion} in a readable format.
     * 
     * @return The name of this {@link MinecraftVersion}
     */
    public String getName() {
        return name;
    }

    /**
     * This method checks whether the given version matches with this
     * {@link MinecraftVersion}.
     * 
     * @param version
     *            The version to compare
     * 
     * @return Whether the version matches with this one
     */
    public boolean matches(String version) {
        return version.startsWith(prefix);
    }

    /**
     * This method checks whether this {@link MinecraftVersion} is newer or equal to
     * the given {@link MinecraftVersion},
     * 
     * @param version
     *            The {@link MinecraftVersion} to compare
     * @return Whether this {@link MinecraftVersion} is newer or equal to the given {@link MinecraftVersion}
     */
    public boolean isAtLeast(MinecraftVersion version) {
        if (this == UNKNOWN) {
            return false;
        }

        return ordinal() >= version.ordinal();
    }

}
