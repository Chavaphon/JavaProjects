import java.util.Scanner;
public class Main{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int pokemonCount = 5;

        Empoleon empoleon = new Empoleon();
        Regice regice = new Regice();
        Slugma slugma = new Slugma();
        Gardevoir gardevoir = new Gardevoir();
        Flapple flapple = new Flapple();

        Pokemon[] arr = new Pokemon[pokemonCount];
        arr[0] = empoleon;
        arr[1] = regice;
        arr[2] = slugma;
        arr[3] = gardevoir;
        arr[4] = flapple;

        for(int i = 0; i < pokemonCount; i++) {
            System.out.print("("+(i+1)+") ");
            arr[i].displayStats();
            arr[i].displayMoves();
            System.out.println();
        }

        System.out.println("Choose Your Pokémon");
        System.out.println();

        Pokemon player1;
        int p1 = sc.nextInt();
        while(p1 < 1 || p1 > pokemonCount) {
            System.out.println("invalid choice(1 - 5)");
            p1 = sc.nextInt();
        }
        player1 = switch (p1) {
            case 2 -> new Regice();
            case 3 -> new Slugma();
            case 4 -> new Gardevoir();
            case 5 -> new Flapple();
            default -> new Empoleon();
        };

        System.out.println("player1 chose: " + player1.getClass().getSimpleName());

        Pokemon player2;
        int p2 = sc.nextInt();
        while(p2 < 1 || p2 > pokemonCount) {
            System.out.println("invalid choice(1 - 5)");
            p2 = sc.nextInt();
        }
        player2 = switch (p2) {
            case 2 -> new Regice();
            case 3 -> new Slugma();
            case 4 -> new Gardevoir();
            case 5 -> new Flapple();
            default -> new Empoleon();
        };

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
    String WATER_TYPE_ADVANTAGE = "fire";
    public void ability();
}

interface SteelType {
    String STEEL_TYPE_ADVANTAGE = "ice";
    public void ability();
}

interface IceType {
    String ICE_TYPE_ADVANTAGE = "flying";
    public void ability();
}

interface FireType {
    String FIRE_TYPE_ADVANTAGE = "grass";
    public void ability();
}

interface PsychicType {
    String PSYCHIC_TYPE_ADVANTAGE = "fighting";
    public void ability();
}

interface FairyType {
    String FAIRY_TYPE_ADVANTAGE = "dragon";
    public void ability();
}

interface GrassType {
    String GRASS_TYPE_ADVANTAGE = "water";
    public void ability();
}

interface DragonType {
     String DRAGON_TYPE_ADVANTAGE = "dragon";
    public void ability();
}
interface PhysicalMove {

    double STAB = 1.5;
    double EFFECTIVE = 2.0;
    public void physicalAttack(Pokemon defender);
    public void displayPhysicalMove();
}

interface SpecialMove {
    double STAB = 1.5;
    double EFFECTIVE = 2.0;
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
    public void displayMoves() {

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
    public void displayMoves() {
        displayPhysicalMove();
        displaySpecialMove();
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
        double damage = ((2.4 * 40 * (this.ATTACK / defender.getDEFENSE())) / 10.0) * PhysicalMove.STAB * damageBoost;
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
        double damage = ((2.4 * 80 * (this.SPECIAL_ATTACK / defender.getSPECIAL_DEFENSE())) / 10.0) * SpecialMove.STAB * damageBoost;
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
    public void displayMoves() {
        displayPhysicalMove();
        displaySpecialMove();
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
        double damage = ((2.4 * 90 * (this.SPECIAL_ATTACK / defender.getSPECIAL_DEFENSE())) / 10.0) * SpecialMove.STAB * damageBoost;
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
    public void displayMoves() {
        displayPhysicalMove();
        displaySpecialMove();
    }
    public void ability() {
        //No ability
    }
    public void physicalAttack(Pokemon defender) {
        String name = "flameCharge";
        double damage = ((2.4 * 50 * (this.ATTACK / defender.getDEFENSE())) / 10.0) * PhysicalMove.STAB * damageBoost;
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
        double damage = ((2.4 * 40 * (this.SPECIAL_ATTACK / defender.getSPECIAL_DEFENSE())) / 10.0) * SpecialMove.STAB * damageBoost;
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
class Gardevoir extends Pokemon implements PsychicType, FairyType, PhysicalMove, SpecialMove{
    public Gardevoir() {
        this.HP = 68;
        this.ATTACK = 65;
        this.DEFENSE = 65;
        this.SPECIAL_ATTACK = 125;
        this.SPECIAL_DEFENSE = 115;
        this.SPEED = 80;
        this.type = "psychic";
    }
    public void displayMoves() {
        displayPhysicalMove();
        displaySpecialMove();
    }
    public void ability() {
        //No ability
    }
    public void physicalAttack(Pokemon defender) {
        String name = "zenHeadbutt";
        double damage = ((2.4 * 80 * (this.ATTACK / defender.getDEFENSE())) / 10.0) * PhysicalMove.STAB * damageBoost;
        System.out.println(this.getClass().getSimpleName() + " used " + name);
        if((PSYCHIC_TYPE_ADVANTAGE).equals(defender.getType())) {
            damage *= PhysicalMove.EFFECTIVE;
            System.out.println("ITS SUPER EFFECTIVE");
        }

        defender.recieveDamage((int) damage);
    }
    public void displayPhysicalMove() {
        System.out.println("(1) ZenHeadbutt(psychic): 80");
    }
    public void specialAttack(Pokemon defender) {
        String name = "drainingKiss";
        double damage = ((2.4 * 50 * (this.SPECIAL_ATTACK / defender.getSPECIAL_DEFENSE())) / 10.0) * SpecialMove.STAB * damageBoost;
        System.out.println(this.getClass().getSimpleName() + " used " + name);
        if((FAIRY_TYPE_ADVANTAGE).equals(defender.getType())) {
            damage *= SpecialMove.EFFECTIVE;
            System.out.println("ITS SUPER EFFECTIVE");
        }

        defender.recieveDamage((int) damage);
    }
    public void displaySpecialMove() {
        System.out.println("(2) DrainingKiss(fairy): 50");
    }
}
class Flapple extends Pokemon implements GrassType, DragonType, PhysicalMove, SpecialMove{
    public Flapple() {
        this.HP = 70;
        this.ATTACK = 110;
        this.DEFENSE = 80;
        this.SPECIAL_ATTACK = 95;
        this.SPECIAL_DEFENSE = 60;
        this.SPEED = 70;
        this.type = "grass";
    }
    public void displayMoves() {
        displayPhysicalMove();
        displaySpecialMove();
    }
    public void ability() {
        //No ability
    }
    public void physicalAttack(Pokemon defender) {
        String name = "trailblaze";
        double damage = ((2.4 * 50 * (this.ATTACK / defender.getDEFENSE())) / 10.0) * PhysicalMove.STAB * damageBoost;
        System.out.println(this.getClass().getSimpleName() + " used " + name);
        if((GRASS_TYPE_ADVANTAGE).equals(defender.getType())) {
            damage *= PhysicalMove.EFFECTIVE;
            System.out.println("ITS SUPER EFFECTIVE");
        }

        defender.recieveDamage((int) damage);
    }
    public void displayPhysicalMove() {
        System.out.println("(1) Trailblaze(grass): 50");
    }

    public void specialAttack(Pokemon defender) {
        String name = "dragonPulse";
        double damage = ((2.4 * 85 * (this.SPECIAL_ATTACK / defender.getSPECIAL_DEFENSE())) / 10.0) * SpecialMove.STAB * damageBoost;
        System.out.println(this.getClass().getSimpleName() + " used " + name);
        if((DRAGON_TYPE_ADVANTAGE).equals(defender.getType())) {
            damage *= SpecialMove.EFFECTIVE;
            System.out.println("ITS SUPER EFFECTIVE");
        }

        defender.recieveDamage((int) damage);
    }
    public void displaySpecialMove() {
        System.out.println("(2) DragonPulse(dragon): 50");
    }
}
