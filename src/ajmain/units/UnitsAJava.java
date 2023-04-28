package ajmain.units;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.ai.*;
import mindustry.ai.types.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;

import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.type.unit.*;
import mindustry.type.weapons.*;
import mindustry.world.meta.*;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;
import mindustry.content.*;

public class UnitsAJava {
    public static UnitType barrier;
    public static void load(){

        barrier = new UnitType("barrier"){{
           speed = 0.55f;
           hitSize = 6f;
           health = 140;
           canBoost = true;
           boostMultiplier = 1.5f;
           constructor = MechUnit::create;

            abilities.add(new ForceFieldAbility(20f, 0.2f, 400f, 20f * 6));

             weapons.add(new PointDefenseWeapon("-point-def"){{
                mirror = false;
                x = 0f;
                y = 0f;
                reload = 9f;
                targetInterval = 10f;
                targetSwitchInterval = 15f;

                bullet = new BulletType(){{
                    shootEffect = Fx.sparkShoot;
                    hitEffect = Fx.pointHit;
                    maxRange = 100f;
                   damage = 17f;
                }};
            }});
        }};


        blockade = new UnitType("blockade"){{
           speed = 0.55f;
           hitSize = 6f;
           health = 140;
           canBoost = true;
           boostMultiplier = 1.5f;
           constructor = MechUnit::create;

            abilities.add(new ShieldArcAbility(){{
                region = "aj-blockade-shield";
                radius = 34f;
                angle = 82f;
                regen = 0.4f;
                cooldown = 150f;
                max = 400f;
                width = 6f;
                y = -6f;
            }});

             weapons.add(new Weapon("-grs"){{
                shootSound: Sounds.missile
                x: 6f;
                y: 1f;
                mirror: true;
                top: false;
                reload: 40f;
                inaccuracy: 20f;
                shoot.shots = 3f;
                shoot.shotDelay = 5f;  

                bullet = new MissileBulletType(2f, 9){{
                    damage: 8f;
                    lifetime: 100f;
                    speed: 3f;
                    healPercent: 1f;
                    collidesTeam: true;
                    backColor: 98FF98;
                    frontColor: FFFFFF;
                }};
            }});
        }};
    }
}