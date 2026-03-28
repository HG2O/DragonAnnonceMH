package com.mh.dragon;

import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.title.Title;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.Duration;
import java.util.Random;

public class DragonAnnounce extends JavaPlugin implements Listener {

    private final Random random = new Random();

    private final TextColor[] colors = {
            NamedTextColor.RED,
            NamedTextColor.GOLD,
            NamedTextColor.AQUA,
            NamedTextColor.LIGHT_PURPLE,
            NamedTextColor.GREEN
    };

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("DragonAnnounce activé !");
    }

    @EventHandler
    public void onDragonDeath(EntityDeathEvent event) {

        if (!(event.getEntity() instanceof EnderDragon dragon)) return;

        Player killer = dragon.getKiller();
        if (killer == null) return;

        FileConfiguration config = getConfig();

        String titleStr    = config.getString("title", "%player% a tué l'Ender Dragon !")
                .replace("%player%", killer.getName());
        String subtitleStr = config.getString("subtitle", "Le boss de l'End est tombé")
                .replace("%player%", killer.getName());
        String chatStr     = config.getString("chat-message", "%player% a vaincu l'Ender Dragon !")
                .replace("%player%", killer.getName());

        TextColor randomColor = colors[random.nextInt(colors.length)];

        Component titleComponent    = Component.text(titleStr, randomColor);
        Component subtitleComponent = Component.text(subtitleStr, NamedTextColor.GRAY);
        Component chatComponent     = Component.text(chatStr, NamedTextColor.GOLD);

        Title title = Title.title(
                titleComponent,
                subtitleComponent,
                Title.Times.times(
                        Duration.ofMillis(500),
                        Duration.ofMillis(4000),
                        Duration.ofMillis(1000)
                )
        );

        for (Player p : Bukkit.getOnlinePlayers()) {
            p.showTitle(title);
            p.playSound(
                    Sound.sound(
                            org.bukkit.NamespacedKey.minecraft("ui.toast.challenge_complete"),
                            Sound.Source.MASTER,
                            1.0f,
                            1.0f
                    )
            );
        }

        Bukkit.broadcast(chatComponent);

        spawnFirework(dragon.getLocation());

        event.getDrops().add(new ItemStack(Material.DRAGON_HEAD, 1));
    }

    private void spawnFirework(Location loc) {
        Firework firework = loc.getWorld().spawn(loc, Firework.class);
        FireworkMeta meta = firework.getFireworkMeta();

        meta.addEffect(
                FireworkEffect.builder()
                        .withColor(Color.PURPLE)
                        .withFade(Color.WHITE)
                        .with(FireworkEffect.Type.BALL_LARGE)
                        .trail(true)
                        .flicker(true)
                        .build()
        );

        meta.setPower(1);
        firework.setFireworkMeta(meta);
    }
}