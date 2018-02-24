package com.songoda.epicspawners.Utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.songoda.arconix.Arconix;
import com.songoda.epicspawners.EpicSpawners;
import org.apache.commons.codec.binary.Base64;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by songoda on 3/19/2017.
 */
public class Heads {

    private Map<String, String> textureURL = new HashMap<>();

    private final EpicSpawners plugin = EpicSpawners.pl();

    public Heads() {
        try {
            for (HeadType type : HeadType.values()) {
                textureURL.put(type.name(), type.getUrl());
            }
        } catch (Exception e) {
            Debugger.runReport(e);
        }
    }

    public ItemStack addTexture(ItemStack item, String name) {
        try {
            String headURL = textureURL.get(name.toUpperCase().replace(" ", "_"));
            if (headURL == null) {
                headURL = textureURL.get("UNKNOWN");
            }
            if (plugin.v1_7) {
                item = new ItemStack(Material.MOB_SPAWNER, 1);
                return item;
            } else {
                return Arconix.pl().getGUI().addTexture(item, headURL);
            }
        } catch (Exception e) {
            Debugger.runReport(e);
        }
        return null;
    }
}