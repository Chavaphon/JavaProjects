import java.util.Scanner;
public class Main{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int pokemonCount = 3;

        Empoleon empoleon = new Empoleon();
        Regice regice = new Regice();
        Slugma slugma = new Slugma();

        System.out.print("(1) ");
        empoleon.displayStats();
        empoleon.displayPhysicalMove();
        empoleon.displaySpecialMove();
        System.out.println();

        System.out.print("(2) ");
        regice.displayStats();
        regice.displayPhysicalMove();
        regice.displaySpecialMove();
        System.out.println();

        System.out.print("(3) ");
        slugma.displayStats();
        slugma.displayPhysicalMove();
        slugma.displaySpecialMove();
        System.out.println();

        System.out.println("Choose Your Pokémon");
        System.out.println();

        Pokemon player1;
        int p1 = sc.nextInt();
        while(p1 < 1 || p1 > pokemonCount) {
            System.out.println("invalid choice(1 - 3)");
            p1 = sc.nextInt();
        }
        if(p1 == 1) {
            player1 = new Empoleon();
        }
        else if(p1 == 2) {
            player1 = new Regice();
        }
        else {
            player1 = new Slugma();
        }

        System.out.println("player1 chose: " + player1.getClass().getSimpleName());

        Pokemon player2;
        int p2 = sc.nextInt();
        while(p2 < 1 || p2 > pokemonCount) {
            System.out.println("invalid choice(1 - 3)");
            p2 = sc.nextInt();
        }
        if(p2 == 1) {
            player2 = new Empoleon();
        }
        else if(p2 == 2) {
            player2 = new Regice();
        }
        else {
            player2 = new Slugma();
        }

        System.out.println("player2 chose: " + player2.getClass().getSimpleName());

        while(!(player1.getFainted() || player2.getFainted())) {
            if(player1.getSpeed() >= player2.getSpeed()) {
                System.out.println("what will player 1 do?");
                ((PhysicalMove) player1).displayPhysicalMove();
                ((SpecialMove) player1).displaySpecialMove();
                int choice1 = sc.nextInt();
                while(choice1 < 1 || choice1 > 2) {
                    System.out.println("invalid choice(1 - 2)");
                    choice1 = sc.nextInt();
                }
                if(choice1 == 1) {
                    ((PhysicalMove) player1).physicalAttack(player2);
                }
                else {
                    ((SpecialMove) player1).specialAttack(player2);
                }

                if(player2.fainted) {
                    break;
                }

                System.out.println("what will player 2 do?");
                ((PhysicalMove) player2).displayPhysicalMove();
                ((SpecialMove) player2).displaySpecialMove();
                int choice2 = sc.nextInt();
                while(choice2 < 1 || choice2 > 2) {
                    System.out.println("invalid choice(1 - 2)");
                    choice2 = sc.nextInt();
                }
                if(choice2 == 1) {
                    ((PhysicalMove) player2).physicalAttack(player1);
                }
                else {
                    ((SpecialMove) player2).specialAttack(player1);
                }
            }
            else {
                System.out.println("what will player 2 do?");
                ((PhysicalMove) player2).displayPhysicalMove();
                ((SpecialMove) player2).displaySpecialMove();
                int choice2 = sc.nextInt();
                while(choice2 < 1 || choice2 > 2) {
                    System.out.println("invalid choice(1 - 2)");
                    choice2 = sc.nextInt();
                }
                if(choice2 == 1) {
                    ((PhysicalMove) player2).physicalAttack(player1);
                }
                else {
                    ((SpecialMove) player2).specialAttack(player1);
                }

                if(player1.fainted) {
                    break;
                }

                System.out.println("what will player 1 do?");
                ((PhysicalMove) player1).displayPhysicalMove();
                ((SpecialMove) player1).displaySpecialMove();
                int choice1 = sc.nextInt();
                while(choice1 < 1 || choice1 > 2) {
                    System.out.println("invalid choice(1 - 2)");
                    choice1 = sc.nextInt();
                }
                if(choice1 == 1) {
                    ((PhysicalMove) player1).physicalAttack(player2);
                }
                else {
                    ((SpecialMove) player1).specialAttack(player2);
                }
            }

        }

        if(player2.getFainted()) {
            System.out.println("player 1 wins!: " + player1.getClass().getSimpleName());
        }
        else {
            System.out.println("player 2 wins!: " + player2.getClass().getSimpleName());
        }
    }
}
interface WaterType {
    final String WATER_TYPE_ADVANTAGE = "fire";
    public void ability();
}

interface SteelType {
    final String STEEL_TYPE_ADVANTAGE = "ice";
    public void ability();
}

interface IceType {
    final String ICE_TYPE_ADVANTAGE = "flying";
    public void ability();
}

interface FireType {
    final String FIRE_TYPE_ADVANTAGE = "grass";
    public void ability();
}

interface PhysicalMove {
    final double STAB = 1.5;
    final double EFFECTIVE = 2.0;
    public void physicalAttack(Pokemon defender);
    public void displayPhysicalMove();
}

interface SpecialMove {
    final double STAB = 1.5;
    final double EFFECTIVE = 2.0;
    public void specialAttack(Pokemon defender);
    public void displaySpecialMove();
}

class Pokemon {
    protected int HP;
    protected double ATTACK;
    protected double DEFENSE;
    protected double SPECIAL_ATTACK;
    protected double SPECIAL_DEFENSE;
    protected double SPEED;
    protected double damageBoost = 1;
    protected String type;
    protected boolean fainted = false;
    public double getSpeed() {
        return this.SPEED;
    }
    public double getSPECIAL_DEFENSE() {
        return SPECIAL_DEFENSE;
    }
    public double getDEFENSE() {
        return DEFENSE;
    }
    public String getType() {
        return type;
    }
    public void displayHealth() {
        System.out.println(this.getClass().getSimpleName()+ "'s HP: " + this.HP);
    }
    public boolean getFainted() {
        return fainted;
    }
    public void faint() {
        this.fainted = true;
    }
    public void displayStats() {
        System.out.println(this.getClass().getSimpleName());
        System.out.println(this.getType());
        System.out.println("HP: " + this.HP);
        System.out.println("ATTACK: " + this.ATTACK);
        System.out.println("DEFENSE: " + this.DEFENSE);
        System.out.println("SPECIAL ATTACK: " + this.SPECIAL_ATTACK);
        System.out.println("SPECIAL DEFENSE: " + this.SPECIAL_DEFENSE);
        System.out.println("SPEED: " + this.SPEED);
    }
    public void recieveDamage(int dmg) {
        this.HP = Math.max(this.HP - dmg, 0);
        System.out.println(this.getClass().getSimpleName()+"'s HP left: " + this.HP);
        if(this.HP <= 0) {
            faint();
            System.out.println(this.getClass().getSimpleName() + " fainted");
        }
        System.out.println();
    }
}
class Empoleon extends Pokemon implements WaterType, SteelType, PhysicalMove, SpecialMove{
    public Empoleon() {
        this.HP = 84;
        this.ATTACK = 86;
        this.DEFENSE = 88;
        this.SPECIAL_ATTACK = 111;
        this.SPECIAL_DEFENSE = 101;
        this.SPEED = 60;
        this.type = "water";
    }
    @Override
    public void recieveDamage(int dmg) {
        this.HP = Math.max(this.HP - dmg, 0);
        System.out.println(this.getClass().getSimpleName()+"'s HP left: " + this.HP);
        if(this.HP <= 0) {
            faint();
            System.out.println(this.getClass().getSimpleName() + " fainted");
        }
        System.out.println();
        ability();
    }
    public void ability() {
        String name = "torrent";
        if(this.HP <= (this.HP / 3)) {
            damageBoost = 1.5;
        }
    }
    public void physicalAttack(Pokemon defender) {
        String name = "aquaJett";
        double damage = ((2.4 * 40 * (this.ATTACK / defender.getDEFENSE())) / 50.0) * PhysicalMove.STAB * damageBoost;
        System.out.println(this.getClass().getSimpleName() + " used " + name);
        if((WATER_TYPE_ADVANTAGE).equals(defender.getType())) {
            damage *= PhysicalMove.EFFECTIVE;
            System.out.println("ITS SUPER EFFECTIVE");
        }

        defender.recieveDamage((int) damage);
    }

    public void displayPhysicalMove() {
        System.out.println("(1) Aquajett(water): 40");
    }

    public void specialAttack(Pokemon defender) {
        String name = "flashCannon";
        double damage = ((2.4 * 80 * (this.ATTACK / defender.getSPECIAL_DEFENSE())) / 50.0) * SpecialMove.STAB * damageBoost;
        System.out.println(this.getClass().getSimpleName() + " used " + name);
        if((STEEL_TYPE_ADVANTAGE).equals(defender.getType())) {
            damage *= SpecialMove.EFFECTIVE;
            System.out.println("ITS SUPER EFFECTIVE");
        }

        defender.recieveDamage((int) damage);
    }

    public void displaySpecialMove() {
        System.out.println("(2) FlashCannon(steel): 80");
    }
}

class Regice extends Pokemon implements IceType, PhysicalMove, SpecialMove{
    public Regice() {
        this.HP = 80;
        this.ATTACK = 50;
        this.DEFENSE = 100;
        this.SPECIAL_ATTACK = 100;
        this.SPECIAL_DEFENSE = 200;
        this.SPEED = 50;
        this.type = "ice";
    }
    public void ability() {
        //No ability
    }
    public void physicalAttack(Pokemon defender) {
        String name = "avalanche";
        double damage = ((2.4 * 60 * (this.ATTACK / defender.getDEFENSE())) / 10.0) * PhysicalMove.STAB * damageBoost;
        System.out.println(this.getClass().getSimpleName() + " used " + name);
        if((ICE_TYPE_ADVANTAGE).equals(defender.getType())) {
            damage *= PhysicalMove.EFFECTIVE;
            System.out.println("ITS SUPER EFFECTIVE");
        }

        defender.recieveDamage((int) damage);
    }

    public void displayPhysicalMove() {
        System.out.println("(1) Avalanche(ice): 60");
    }

    public void specialAttack(Pokemon defender) {
        String name = "iceBeam";
        double damage = ((2.4 * 90 * (this.ATTACK / defender.getSPECIAL_DEFENSE())) / 10.0) * SpecialMove.STAB * damageBoost;
        System.out.println(this.getClass().getSimpleName() + " used " + name);
        if((ICE_TYPE_ADVANTAGE).equals(defender.getType())) {
            damage *= SpecialMove.EFFECTIVE;
            System.out.println("ITS SUPER EFFECTIVE");
        }

        defender.recieveDamage((int) damage);
    }

    public void displaySpecialMove() {
        System.out.println("(2) IceBeam(ice): 90");
    }
}
class Slugma extends Pokemon implements FireType, PhysicalMove, SpecialMove{
    public Slugma() {
        this.HP = 40;
        this.ATTACK = 40;
        this.DEFENSE = 40;
        this.SPECIAL_ATTACK = 70;
        this.SPECIAL_DEFENSE = 40;
        this.SPEED = 20;
        this.type = "fire";
    }
    public void ability() {
        //No ability
    }
    public void physicalAttack(Pokemon defender) {
        String name = "earthquake";
        double damage = ((2.4 * 100 * (this.ATTACK / defender.getDEFENSE())) / 10.0) * PhysicalMove.STAB * damageBoost;
        System.out.println(this.getClass().getSimpleName() + " used " + name);
        if((FIRE_TYPE_ADVANTAGE).equals(defender.getType())) {
            damage *= PhysicalMove.EFFECTIVE;
            System.out.println("ITS SUPER EFFECTIVE");
        }

        defender.recieveDamage((int) damage);
    }

    public void displayPhysicalMove() {
        System.out.println("(1) Earthquake(ground): 100");
    }

    public void specialAttack(Pokemon defender) {
        String name = "ember";
        double damage = ((2.4 * 40 * (this.ATTACK / defender.getSPECIAL_DEFENSE())) / 10.0) * SpecialMove.STAB * damageBoost;
        System.out.println(this.getClass().getSimpleName() + " used " + name);
        if((FIRE_TYPE_ADVANTAGE).equals(defender.getType())) {
            damage *= SpecialMove.EFFECTIVE;
            System.out.println("ITS SUPER EFFECTIVE");
        }

        defender.recieveDamage((int) damage);
    }

    public void displaySpecialMove() {
        System.out.println("(2) Ember(fire): 40");
    }
}