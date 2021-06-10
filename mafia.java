import java.util.*;
import java.lang.Math;
final class Alloted{
    private final int healer;
    private final int mafia;
    private final int detectives;
    private final int commoners;

    Alloted(int n) {
        int heal;
        mafia = (int) Math.floor(n/5);
        detectives = (int) Math.floor(n/5);
        heal= (int) Math.floor(n/10);
        healer = Math.max(1,heal);
        commoners = n - mafia -detectives -healer ;
    }

    public int getMafia(){return mafia;}
    public int getHealer(){return healer;}
    public int getDetectives(){return detectives;}
    public int getCommoners(){return commoners;}
}
abstract class players {

    public void voting(ArrayList<info1> arr){
        Random rand = new Random();
        for(int i=0; i<arr.size(); i++) {
            int ran = rand.nextInt(arr.size());
            String player = arr.get(i).getPlayer();
            int c = Integer.parseInt(player.substring(6));
            arr.get(i).setCount(c);

        }}
    public char userplayertest (ArrayList<info1> arr,String player){
        int flag =0;
        for(int i=0; i<arr.size(); i++){
            if(arr.get(i).getPlayer().equals(player)){
                flag =1;
            }
        }
        if(flag == 0){
            return 'd';
        }
        else{
            return 'a';
        }
    }
}
class game extends players {
    public void over(ArrayList<info> mafiacopy, ArrayList<info> detectivecopy, ArrayList<info> healercopy, ArrayList<info> commonercopy, int flag) {
        System.out.println("**GAME OVER**");
        if(flag == 0){
            System.out.println("The Mafias have lost.");
        }
        else{
            System.out.println("The Mafias have won.");
        }
        String s = "";
        for (int i = 0; i < mafiacopy.size(); i++) {
            s = s + mafiacopy.get(i).getPlayer() + " ";
        }
        System.out.println(s + " " + "were mafias.");
        String s1 = "";
        for (int i = 0; i < detectivecopy.size(); i++) {
            s1 = s1 + detectivecopy.get(i).getPlayer() + " ";
        }
        System.out.println(s1 + " " + "were detectives.");
        String s2 = "";
        for (int i = 0; i < healercopy.size(); i++) {
            s2 = s2 + healercopy.get(i).getPlayer() + " ";
        }
        System.out.println(s2 + " " + "were Healers.");
        String s3 = "";
        for (int i = 0; i < commonercopy.size(); i++) {
            s3 = s3 + commonercopy.get(i).getPlayer() + " ";
        }
        System.out.println(s3 + " " + "were Commoners.");

    }
    public void mafiavoteout(MafiaGame<info> mafia ,String detectiveplayers ,ArrayList<info1> Player){
        for (int i = 0; i < mafia.getMylist().size(); i++) {
            if ((mafia.getMylist().get(i).getPlayer()).equals(detectiveplayers)) {
                mafia.getMylist().remove(i);
                break;
            }
        }
        for (int a = 0; a < Player.size(); a++) {
            if (Player.get(a).getPlayer().equals(detectiveplayers)) {
                Player.remove(a);
                break;
            }
        }
    }
    public void voteout(String pp, char ck, ArrayList<info1> Player, ArrayList<info1> targeters, MafiaGame<info> detective, MafiaGame<info> mafia, MafiaGame<info> healer, MafiaGame<info> commoner) {
        if (ck == 'D') {
            for (int i = 0; i < detective.getMylist().size(); i++) {
                if ((detective.getMylist().get(i).getPlayer()).equals(pp)) {
                    detective.getMylist().remove(i);
                    break;
                }
            }
            for (int a = 0; a < Player.size(); a++) {
                if (Player.get(a).getPlayer().equals(pp)) {
                    Player.remove(a);
                    break;
                }
            }
            for (int a = 0; a < targeters.size(); a++) {
                if (targeters.get(a).getPlayer().equals(pp)) {
                    targeters.remove(a);
                    break;
                }
            }
        } else if (ck == 'M') {
            for (int i = 0; i < mafia.getMylist().size(); i++) {
                if ((mafia.getMylist().get(i).getPlayer()).equals(pp)) {
                    mafia.getMylist().remove(i);
                    break;
                }
            }
            for (int a = 0; a < Player.size(); a++) {
                if (Player.get(a).getPlayer().equals(pp)) {
                    Player.remove(a);
                    break;
                }
            }
        } else if (ck == 'H') {
            for (int i = 0; i < healer.getMylist().size(); i++) {
                if ((healer.getMylist().get(i).getPlayer()).equals(pp)) {
                    healer.getMylist().remove(i);
                    break;
                }
            }
            for (int a = 0; a < Player.size(); a++) {
                if (Player.get(a).getPlayer().equals(pp)) {
                    Player.remove(a);
                    break;
                }
            }
            for (int a = 0; a < targeters.size(); a++) {
                if (targeters.get(a).getPlayer().equals(pp)) {
                    targeters.remove(a);
                    break;
                }
            }
        } else {
            for (int i = 0; i < commoner.getMylist().size(); i++) {
                if ((commoner.getMylist().get(i).getPlayer()).equals(pp)) {
                    commoner.getMylist().remove(i);
                    break;
                }
            }
            for (int a = 0; a < Player.size(); a++) {
                if (Player.get(a).getPlayer().equals(pp)) {
                    Player.remove(a);
                    break;
                }
            }
            for (int a = 0; a < targeters.size(); a++) {
                if (targeters.get(a).getPlayer().equals(pp)) {
                    targeters.remove(a);
                    break;
                }
            }
        }
    }
    public void killTarget(char fch, String mafiachoosenplayer, MafiaGame<info> detective, ArrayList<info1> Player, ArrayList<info1> targeters, MafiaGame<info> healer, MafiaGame<info> commoner) {
        if (fch == 'D') {
            for (int i = 0; i < detective.getMylist().size(); i++) {
                if ((detective.getMylist().get(i).getPlayer()).equals(mafiachoosenplayer)) {
                    if (detective.getMylist().get(i).getHP() == 0) {
                        detective.getMylist().remove(i);
                        for (int a = 0; a < Player.size(); a++) {
                            if (Player.get(a).getPlayer().equals(mafiachoosenplayer)) {
                                Player.remove(a);
                                break;
                            }
                        }
                        for (int a = 0; a < targeters.size(); a++) {
                            if (targeters.get(a).getPlayer().equals(mafiachoosenplayer)) {
                                targeters.remove(a);
                                break;
                            }
                        }
                        System.out.println(mafiachoosenplayer + " has died.");
                    } else {
                        System.out.println("No one died.");
                    }
                }
            }
        } else if (fch == 'H') {
            for (int i = 0; i < healer.getMylist().size(); i++) {
                if ((healer.getMylist().get(i).getPlayer()).equals(mafiachoosenplayer)) {
                    if (healer.getMylist().get(i).getHP() == 0) {
                        healer.getMylist().remove(i);
                        for (int a = 0; a < Player.size(); a++) {
                            if (Player.get(a).getPlayer().equals(mafiachoosenplayer)) {
                                Player.remove(a);
                                break;
                            }
                        }
                        for (int a = 0; a < targeters.size(); a++) {
                            if (targeters.get(a).getPlayer().equals(mafiachoosenplayer)) {
                                targeters.remove(a);
                                break;
                            }
                        }
                        System.out.println(mafiachoosenplayer + " has died.");
                    } else {
                        System.out.println("No one died.");
                    }
                }
            }
        } else {
            for (int i = 0; i < commoner.getMylist().size(); i++) {
                if ((commoner.getMylist().get(i).getPlayer()).equals(mafiachoosenplayer)) {
                    if (commoner.getMylist().get(i).getHP() == 0) {
                        commoner.getMylist().remove(i);
                        for (int a = 0; a < Player.size(); a++) {
                            if (Player.get(a).getPlayer().equals(mafiachoosenplayer)) {
                                Player.remove(a);
                                break;
                            }
                        }
                        for (int a = 0; a < targeters.size(); a++) {
                            if (targeters.get(a).getPlayer().equals(mafiachoosenplayer)) {
                                targeters.remove(a);
                                break;
                            }
                        }
                        System.out.println(mafiachoosenplayer + " has died.");
                    } else {
                        System.out.println("No one died.");
                    }
                }
            }
        }
    }
}

class info{
    private String player;
    private char status;
    private float HP;
    info(String p, int hp){
        this.player =p;
        this.HP = hp;
    }
    public String toString(){
        return player+" "+status+" "+HP;
    }
    public String getPlayer(){return player;}
    public float getHP(){return HP;}
    public void setPlayer(String p){
        player = p;
    }
    public void setHP(float a){
        HP = a ;
    }
}
class Healer{

    public void HealerRole(ArrayList<info1> arr , MafiaGame<info> mafia ,MafiaGame<info> dective ,MafiaGame<info> commoner,MafiaGame<info> healer,String player){
        Random rand = new Random();
        char role;
        float sethp ;
        if (player.equals("null")) {
            int ran = rand.nextInt(arr.size());
            player = arr.get(ran).getPlayer();
            role = arr.get(ran).getRole();
        } else {
            Detective ob = new Detective();
            role = ob.test(arr,player);
        }
        if(role == 'M'){
            for(int i=0; i<mafia.getMylist().size(); i++){
                if(mafia.getMylist().get(i).getPlayer().equals(player)){
                    sethp = mafia.getMylist().get(i).getHP();
                    sethp = sethp + 500;
                    mafia.getMylist().get(i).setHP(sethp);
                }
            }
        }
        else if(role == 'D'){
            for(int i=0; i<dective.getMylist().size(); i++){
                if(dective.getMylist().get(i).getPlayer().equals(player)){
                    sethp = dective.getMylist().get(i).getHP();
                    sethp = sethp + 500;
                    dective.getMylist().get(i).setHP(sethp);
                }
            }
        }
        else if(role == 'H'){
            for(int i=0; i<healer.getMylist().size(); i++){
                if(healer.getMylist().get(i).getPlayer().equals(player)){
                    sethp = healer.getMylist().get(i).getHP();
                    sethp = sethp + 500;
                    healer.getMylist().get(i).setHP(sethp);
                }
            }
        }
        else{
            for(int i=0; i<commoner.getMylist().size(); i++){
                if(commoner.getMylist().get(i).getPlayer().equals(player)){
                    sethp = commoner.getMylist().get(i).getHP();
                    sethp = sethp + 500;
                    commoner.getMylist().get(i).setHP(sethp);
                }
            }
        }
    }
}
class info1 implements Comparable<info1>{
    private String player;
    private char role;
    private int count;
    info1(String p, char r){
        this.player =p;
        this.role =r;
    }
    info1(String p ,char r , int c){
        this.player =p;
        this.role =r;
        this.count =c;
    }
    public String toString(){
        return player+" "+role+" ";
    }

    public String getPlayer(){return player;}
    public int getCount(){return count;}
    public char getRole(){return role;}
    public void setRole(char a){
        role = a ;
    }
    public void setCount(int a){
        count = a ;
    }
    @Override
    public int compareTo( info1 o) {
        int o1 = ((info1)o).getCount();
        return o1-this.count;
    }
}
class Detective{
    public String DetectiveRole (ArrayList<info1> arr){
        Random rand = new Random();
        int ran = rand.nextInt(arr.size());
        String player = arr.get(ran).getPlayer();
        return player ;

    }
    public char test(ArrayList<info1> arr ,String player){
        char role = 'N';
        for(int i=0; i<arr.size(); i++){
            if(arr.get(i).getPlayer().equals(player)){
                role = arr.get(i).getRole();
            }
        }
        if(role == 'D'){
            return 'D';
        }
        else if(role == 'M'){
            return 'M';
        }
        else if(role == 'H'){
            return 'H';
        }
        else{
            return 'C';
        }

    }
}
class Mafia {
    Random rand = new Random();

    public String MafiaRole(ArrayList<info1> arr, MafiaGame<info> mafia, MafiaGame<info> dective, MafiaGame<info> commoner, MafiaGame<info> healer, String player) {
        char role;
        if (player.equals("null")) {
            int ran = rand.nextInt(arr.size());
            player = arr.get(ran).getPlayer();
            role = arr.get(ran).getRole();
        } else {
            Detective ob = new Detective();
            role = ob.test(arr,player);
        }

    int mafias = mafia.getMylist().size();
    float absorb;
    if(role =='D'){
        for (int i = 0; i < dective.getMylist().size(); i++) {
            if (dective.getMylist().get(i).getPlayer().equals(player)) {
                float mafiaHP = 0;
                for (int j = 0; j < mafia.getMylist().size(); j++) {
                    mafiaHP = mafiaHP + mafia.getMylist().get(j).getHP();
                }
                float targetHP = dective.getMylist().get(i).getHP();
                if (mafiaHP >= targetHP) {
                    dective.getMylist().get(i).setHP(0);
                    float damages = targetHP / mafias;
                    for (int k = 0; k < mafia.getMylist().size(); k++) {
                        float get = mafia.getMylist().get(k).getHP();
                        if (get >= damages) {
                            get = get - damages;
                            mafia.getMylist().get(k).setHP(get);
                            --mafias;
                        } else {
                            absorb = damages - get;
                            mafia.getMylist().get(k).setHP(0);
                            --mafias;
                            damages = (damages + absorb) / mafias;
                        }
                    }
                } else {
                    targetHP = targetHP - mafiaHP;
                    dective.getMylist().get(i).setHP(targetHP);

                }

            }

        }
    } else if(role =='H'){
        for (int i = 0; i < healer.getMylist().size(); i++) {
            if (healer.getMylist().get(i).getPlayer().equals(player)) {
                float mafiaHP = 0;
                for (int j = 0; j < mafia.getMylist().size(); j++) {
                    mafiaHP = mafiaHP + mafia.getMylist().get(j).getHP();
                }
                float targetHP = healer.getMylist().get(i).getHP();
                if (mafiaHP >= targetHP) {
                    healer.getMylist().get(i).setHP(0);
                    float damages = targetHP / mafias;
                    for (int k = 0; k < mafia.getMylist().size(); k++) {
                        float get = mafia.getMylist().get(k).getHP();
                        if (get >= damages) {
                            get = get - damages;
                            mafia.getMylist().get(k).setHP(get);
                            --mafias;
                        } else {
                            absorb = damages - get;
                            mafia.getMylist().get(k).setHP(0);
                            --mafias;
                            damages = (damages + absorb) / mafias;
                        }
                    }
                } else {
                    targetHP = targetHP - mafiaHP;
                    healer.getMylist().get(i).setHP(targetHP);

                }

            }

        }
    } else

    {
        for (int i = 0; i < commoner.getMylist().size(); i++) {
            if (commoner.getMylist().get(i).getPlayer().equals(player)) {
                float mafiaHP = 0;
                for (int j = 0; j < mafia.getMylist().size(); j++) {
                    mafiaHP = mafiaHP + mafia.getMylist().get(j).getHP();
                }
                float targetHP = commoner.getMylist().get(i).getHP();
                if (mafiaHP >= targetHP) {
                    commoner.getMylist().get(i).setHP(0);
                    float damages = targetHP / mafias;
                    for (int k = 0; k < mafia.getMylist().size(); k++) {
                        float get = mafia.getMylist().get(k).getHP();
                        if (get >= damages) {
                            get = get - damages;
                            mafia.getMylist().get(k).setHP(get);
                            --mafias;
                        } else {
                            absorb = damages - get;
                            mafia.getMylist().get(k).setHP(0);
                            --mafias;
                            damages = (damages + absorb) / mafias;
                        }
                    }
                } else {
                    targetHP = targetHP - mafiaHP;
                    commoner.getMylist().get(i).setHP(targetHP);

                }
            }

        }

    }
        return player;
}
        }
class MafiaGame <T> implements Cloneable{
    private ArrayList <T> mylist;
    public MafiaGame(){
            mylist = new ArrayList <T>();
        }
        public void add(T o) {
            mylist.add(o);
        }
        public T get(int i) {
            return mylist.get(i);
    }
        public void remove(int i){
            mylist.remove(i);
        }
        public ArrayList<T> getMylist(){
            return mylist;
        }
        public ArrayList<T> clone(){
        try{
            MafiaGame<T> copy = (MafiaGame<T>) super.clone();
            copy.mylist = new ArrayList<T>(mylist);
            return copy.mylist ;

        } catch (CloneNotSupportedException e) {
            return null;
        }
        }
}
public class Assign3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        game ob = new game();
        Detective dect = new Detective();
        MafiaGame<info> mafia = new MafiaGame<info>();
        MafiaGame<info> detective = new MafiaGame<info>();
        MafiaGame<info> healer = new MafiaGame<info>();
        MafiaGame<info> commoner = new MafiaGame<info>();
        ArrayList<Integer> numPlayer = new ArrayList<Integer>();
        ArrayList<info1> Player = new ArrayList<info1>();
        ArrayList<info1> targeters = new ArrayList<info1>();
        Mafia maf = new Mafia();
        Detective decti = new Detective();
        Healer he = new Healer();
        System.out.print("Enter number of players : ");
        int n = in.nextInt();
        if (n < 6) {
            System.out.println("Players can't be less than 6");
            System.out.print("Enter again the number of players : ");
            n = in.nextInt();
        }
        Alloted ob1 = new Alloted(n);
        System.out.println("Choose a Character");
        System.out.println("1) Mafia\n" + "2) Detective\n" + "3) Healer\n" + "4) Commoner\n" + "5) Assign Randomly");
        for (int i = 0; i < n; i++) {
            int a = i + 1;
            numPlayer.add(a);
            String s = "Player" + a;
            Player.add(new info1(s, 'N'));
        }
        for (int i = 0; i < ob1.getMafia(); i++) {
            int ran = rand.nextInt(numPlayer.size());
            int a = numPlayer.get(ran);
            Player.get(a - 1).setRole('M');
            String s = "Player" + a;
            mafia.add(new info(s, 2500));
            numPlayer.remove(ran);
        }
        for (int i = 0; i < ob1.getDetectives(); i++) {
            int ran = rand.nextInt(numPlayer.size());
            int a = numPlayer.get(ran);
            Player.get(a - 1).setRole('D');
            String s = "Player" + a;
            detective.add(new info(s, 800));
            numPlayer.remove(ran);
        }
        for (int i = 0; i < ob1.getHealer(); i++) {
            int ran = rand.nextInt(numPlayer.size());
            int a = numPlayer.get(ran);
            Player.get(a - 1).setRole('H');
            String s = "Player" + a;
            healer.add(new info(s, 800));
            numPlayer.remove(ran);
        }
        for (int i = 0; i < ob1.getCommoners(); i++) {
            int a = numPlayer.get(i);
            Player.get(a - 1).setRole('C');
            String s = "Player" + a;
            commoner.add(new info(s, 1000));
        }

        for (int i = 0; i < Player.size(); i++) {
            if (Player.get(i).getRole() != 'M') {
                targeters.add(new info1(Player.get(i).getPlayer(), Player.get(i).getRole()));
            }
        }
        ArrayList<info> mafiacopy = mafia.clone();
        ArrayList<info> detectivecopy = detective.clone();
        ArrayList<info> healercopy = healer.clone();
        ArrayList<info> commonercopy = commoner.clone();
        String userplayer;
        int usernum, round;
        String p1;
        int fl;
        char check = 'N';
        int user = in.nextInt();
        if (user == 5) {
            user = rand.nextInt(4);
            ++user;
        }
            switch (user) {
                case 1:
                    usernum = rand.nextInt(mafia.getMylist().size());
                    userplayer = mafia.getMylist().get(usernum).getPlayer();
                    p1 = "";
                    for (int i = 0; i < mafia.getMylist().size(); i++) {
                        if ((mafia.getMylist().get(i).getPlayer()).equals(userplayer)) {
                            mafiacopy.get(i).setPlayer(userplayer + "[user]");
                        } else {
                            p1 = p1 + mafia.getMylist().get(i).getPlayer() + " ";
                        }
                    }
                    System.out.println("You are " + userplayer + ".");
                    System.out.println("Yor are a mafia. " + "Other mafia are : " + p1);
                    round = 1;
                    fl = 0;
                    while (mafia.getMylist().size() != 0) {
                        if (mafia.getMylist().size() == (detective.getMylist().size() + healer.getMylist().size()+commoner.getMylist().size())){
                            fl = 1;
                            ob.over(mafiacopy, detectivecopy, healercopy, commonercopy, fl);
                            break;
                        } else {
                            System.out.println("Round " + round);
                            System.out.print(Player.size() + " players are remaining : ");
                        String h="";
                        for(int i =0; i<Player.size(); i++){
                            h=h+Player.get(i).getPlayer()+" ";
                        }
                        System.out.print(h+" ");
                            System.out.print(Player);
                            System.out.println("are alive.");
                            int df = 0;
                            int test;
                            String player = null, detectiveplayers = null;
                            String mafiachoosenplayer;
                            if (ob.userplayertest(Player, userplayer) == 'a') {
                                System.out.print("Choose a target : ");
                                test = in.nextInt();
                                player = "Player" + test;
                                check = decti.test(Player, player);
                                while (check == 'M') {
                                    System.out.print("You cannot target a mafia. ");
                                    System.out.print("Choose a target : ");
                                    test = in.nextInt();
                                    player = "Player" + test;
                                    check = decti.test(Player, player);
                                }
                                mafiachoosenplayer = maf.MafiaRole(targeters, mafia, detective, commoner, healer, player);
                            } else {
                                System.out.println("Mafias have chosen their target.");
                                mafiachoosenplayer = maf.MafiaRole(targeters, mafia, detective, commoner, healer, "null");
                            }
                            System.out.println("Detectives have chosen a player to test.");
                            if (detective.getMylist().size() != 0) {
                                df = 1;
                                detectiveplayers = decti.DetectiveRole(Player);
                            }
                            System.out.println("Healer have chosen to Heal.");
                            if (healer.getMylist().size() != 0) {
                                he.HealerRole(Player, mafia, detective, commoner, healer, "null");
                            }
                            System.out.println("--End of actions--");
                            char fch = decti.test(targeters, mafiachoosenplayer);
                            ob.killTarget(fch, mafiachoosenplayer, detective, Player, targeters, healer, commoner);
                            int hd = 0;
                            if (df == 1) {
                                char what = decti.test(Player, detectiveplayers);
                                if (what == 'M') {
                                    hd = 1;
                                    System.out.println(detectiveplayers + " has been voted out.");
                                    ob.mafiavoteout(mafia, detectiveplayers, Player);
                                }
                            }
                            if (hd == 0) {
                                if (ob.userplayertest(Player, userplayer) == 'a') {
                                    System.out.print("Select a person to vote out : ");
                                    int vote = in.nextInt();
                                    int ra = rand.nextInt(Player.size());
                                    String pp = Player.get(ra).getPlayer();
                                    System.out.println(pp + " has been voted out.");
                                    char ck = decti.test(Player, pp);
                                    ob.voteout(pp, ck, Player, targeters, detective, mafia, healer, commoner);
                                } else {
                                    int ra = rand.nextInt(Player.size());
                                    String pp = Player.get(ra).getPlayer();
                                    char ck = decti.test(Player, pp);
                                    System.out.println(pp + " has been voted out.");
                                    ob.voteout(pp, ck, Player, targeters, detective, mafia, healer, commoner);
                                }
                            }
                            System.out.println("--End of round" + round);
                            ++round;
                        }

                    }
                    if (fl == 0) {
                        ob.over(mafiacopy, detectivecopy, healercopy, commonercopy, fl);
                    }
                    break;

                case 2:
                    usernum = rand.nextInt(detective.getMylist().size());
                    userplayer = detective.getMylist().get(usernum).getPlayer();
                    p1 = "";
                    for (int i = 0; i < detective.getMylist().size(); i++) {
                        if ((detective.getMylist().get(i).getPlayer()).equals(userplayer)) {
                            detectivecopy.get(i).setPlayer(userplayer + "[user]");
                        } else {
                            p1 = p1 + detective.getMylist().get(i).getPlayer() + " ";
                        }
                    }
                    System.out.println("You are " + userplayer + ".");
                    System.out.println("Yor are a detective. " + "Other detectives are : " + p1);
                    round = 1;
                    fl = 0;
                    while (mafia.getMylist().size() != 0) {
                        if (mafia.getMylist().size() == (detective.getMylist().size() + healer.getMylist().size()+commoner.getMylist().size())) {
                            fl = 1;
                            ob.over(mafiacopy, detectivecopy, healercopy, commonercopy, fl);
                            break;
                        } else {
                            System.out.println("Round " + round);
                            System.out.print(Player.size() + " players are remaining : ");
                        String h="";
                        for(int i =0; i<Player.size(); i++){
                            h=h+Player.get(i).getPlayer()+" ";
                        }
                        System.out.print(h+" ");
//                            System.out.print(Player);
                            System.out.println("are alive.");
                            System.out.println("Mafias have chosen their target.");
                            int df = 0;
                            String mafiachoosenplayer = maf.MafiaRole(targeters, mafia, detective, commoner, healer, "null");
                            int test;
                            String player = null, detectiveplayers = null;
                            if (ob.userplayertest(Player, userplayer) == 'a') {
                                System.out.print("Choose a player to test : ");
                                test = in.nextInt();
                                player = "Player" + test;
                                check = decti.test(Player, player);
                                while (check == 'D') {
                                    System.out.print("You cannot test a detective. ");
                                    System.out.print("Choose a player to test : ");
                                    test = in.nextInt();
                                    player = "Player" + test;
                                    check = decti.test(Player, player);
                                }
                                if (check == 'M') {
                                    System.out.println("Player" + test + " is a Mafia");
                                } else {
                                    System.out.println("Player" + test + " is not a Mafia");
                                }
                            } else {
                                System.out.println("Detectives have chosen a player to test.");
                                if (detective.getMylist().size() != 0) {
                                    df = 1;
                                    detectiveplayers = decti.DetectiveRole(Player);
                                }
                            }
                            System.out.println("Healer have chosen to Heal.");
                            if (healer.getMylist().size() != 0) {
                                he.HealerRole(Player, mafia, detective, commoner, healer, "null");
                            }
                            System.out.println("--End of actions--");
                            char fch = decti.test(targeters, mafiachoosenplayer);
                            ob.killTarget(fch, mafiachoosenplayer, detective, Player, targeters, healer, commoner);
                            if (ob.userplayertest(Player, userplayer) == 'a') {
                                if (check == 'M') {
                                    System.out.println(player + " has been voted out.");
                                    ob.mafiavoteout(mafia, player, Player);
                                } else {
                                    System.out.print("Select a person to vote out : ");
                                    int vote = in.nextInt();
                                    int ra = rand.nextInt(Player.size());
                                    String pp = Player.get(ra).getPlayer();
                                    System.out.println(pp + " has been voted out.");
                                    char ck = decti.test(Player, pp);
                                    ob.voteout(pp, ck, Player, targeters, detective, mafia, healer, commoner);
                                }
                            } else {
                                int hd = 0;
                                if (df == 1) {
                                    char what = decti.test(Player, detectiveplayers);
                                    if (what == 'M') {
                                        hd = 1;
                                        System.out.println(detectiveplayers + " has been voted out.");
                                        ob.mafiavoteout(mafia, detectiveplayers, Player);
                                    }
                                }
                                if (hd == 0) {
                                    int ra = rand.nextInt(Player.size());
                                    String pp = Player.get(ra).getPlayer();
                                    char ck = decti.test(Player, pp);
                                    System.out.println(pp + " has been voted out.");
                                    ob.voteout(pp, ck, Player, targeters, detective, mafia, healer, commoner);
                                }
                            }
                            System.out.println("--End of round" + round);
                            ++round;
                        }
                    }
                    if (fl == 0) {
                        ob.over(mafiacopy, detectivecopy, healercopy, commonercopy, fl);
                    }
                    break;
                case 3:
                    usernum = rand.nextInt(healer.getMylist().size());
                    userplayer = healer.getMylist().get(usernum).getPlayer();
                    p1 = "";
                    for (int i = 0; i < healer.getMylist().size(); i++) {
                        if ((healer.getMylist().get(i).getPlayer()).equals(userplayer)) {
                            healercopy.get(i).setPlayer(userplayer + "[user]");
                        } else {
                            p1 = p1 + healer.getMylist().get(i).getPlayer() + " ";
                        }
                    }
                    System.out.println("You are " + userplayer + ".");
                    System.out.println("Yor are a healer. " + "Other healers are : " + p1);
                    round = 1;
                    fl = 0;
                    while (mafia.getMylist().size() != 0) {
                        if (mafia.getMylist().size() == (detective.getMylist().size() + healer.getMylist().size()+commoner.getMylist().size())) {
                            fl = 1;
                            ob.over(mafiacopy, detectivecopy, healercopy, commonercopy, fl);
                            break;
                        } else {
                            System.out.println("Round " + round);
                            System.out.print(Player.size() + " players are remaining : ");
                        String h="";
                        for(int i =0; i<Player.size(); i++){
                            h=h+Player.get(i).getPlayer()+" ";
                        }
                        System.out.print(h+" ");
//                            System.out.print(Player);
                            System.out.println("are alive.");
                            System.out.println("Mafias have chosen their target.");
                            int df = 0;
                            String mafiachoosenplayer = maf.MafiaRole(targeters, mafia, detective, commoner, healer, "null");
                            int test;
                            String player = null, detectiveplayers = null;
                            System.out.println("Detectives have chosen a player to test.");
                            if (detective.getMylist().size() != 0) {
                                df = 1;
                                detectiveplayers = decti.DetectiveRole(Player);
                            }
                            if (ob.userplayertest(Player, userplayer) == 'a') {
                                System.out.print("Choose a player to heal : ");
                                test = in.nextInt();
                                player = "Player" + test;
                                he.HealerRole(Player, mafia, detective, commoner, healer, player);
                            } else {
                                System.out.println("Healer have chosen to Heal.");
                                if (healer.getMylist().size() != 0) {
                                    he.HealerRole(Player, mafia, detective, commoner, healer, "null");
                                }
                            }
                            System.out.println("--End of actions--");
                            char fch = decti.test(targeters, mafiachoosenplayer);
                            ob.killTarget(fch, mafiachoosenplayer, detective, Player, targeters, healer, commoner);
                            int hd = 0;
                            if (df == 1) {
                                char what = decti.test(Player, detectiveplayers);
                                if (what == 'M') {
                                    hd = 1;
                                    System.out.println(detectiveplayers + " has been voted out.");
                                    ob.mafiavoteout(mafia, detectiveplayers, Player);
                                }
                            }
                            if (hd == 0) {
                                if (ob.userplayertest(Player, userplayer) == 'a') {
                                    System.out.print("Select a person to vote out : ");
                                    int vote = in.nextInt();
                                    int ra = rand.nextInt(Player.size());
                                    String pp = Player.get(ra).getPlayer();
                                    System.out.println(pp + " has been voted out.");
                                    char ck = decti.test(Player, pp);
                                    ob.voteout(pp, ck, Player, targeters, detective, mafia, healer, commoner);

                                } else {
                                    int ra = rand.nextInt(Player.size());
                                    String pp = Player.get(ra).getPlayer();
                                    char ck = decti.test(Player, pp);
                                    System.out.println(pp + " has been voted out.");
                                    ob.voteout(pp, ck, Player, targeters, detective, mafia, healer, commoner);
                                }
                            }
                            System.out.println("--End of round" + round);
                            ++round;
                        }
                    }
                    if (fl == 0) {
                        ob.over(mafiacopy, detectivecopy, healercopy, commonercopy, fl);
                    }
                    break;
                case 4:
                    usernum = rand.nextInt(commoner.getMylist().size());
                    userplayer = commoner.getMylist().get(usernum).getPlayer();
                    p1 = "";
                    for (int i = 0; i < commoner.getMylist().size(); i++) {
                        if ((commoner.getMylist().get(i).getPlayer()).equals(userplayer)) {
                            commonercopy.get(i).setPlayer(userplayer + "[user]");
                        } else {
                            p1 = p1 + commoner.getMylist().get(i).getPlayer() + " ";
                        }
                    }
                    System.out.println("You are " + userplayer + ".");
                    System.out.println("Yor are a commoner. " + "Other commoners are : " + p1);
                    round = 1;
                    fl = 0;
                    while (mafia.getMylist().size() != 0) {
                        if (mafia.getMylist().size() == (detective.getMylist().size() + healer.getMylist().size()+commoner.getMylist().size())) {
                            fl = 1;
                            ob.over(mafiacopy, detectivecopy, healercopy, commonercopy, fl);
                            break;
                        } else {
                            System.out.println("Round " + round);
                            System.out.print(Player.size() + " players are remaining : ");
                        String h="";
                        for(int i =0; i<Player.size(); i++){
                            h=h+Player.get(i).getPlayer()+" ";
                        }
                        System.out.print(h+" ");
//                            System.out.print(Player);
                            System.out.println("are alive.");
                            System.out.println("Mafias have chosen their target.");
                            int df = 0;
                            String mafiachoosenplayer = maf.MafiaRole(targeters, mafia, detective, commoner, healer, "null");
                            int test;
                            String player = null, detectiveplayers = null;
                            System.out.println("Detectives have chosen a player to test.");
                            if (detective.getMylist().size() != 0) {
                                df = 1;
                                detectiveplayers = decti.DetectiveRole(Player);
                            }
                            System.out.println("Healer have chosen to Heal.");
                            if (healer.getMylist().size() != 0) {
                                he.HealerRole(Player, mafia, detective, commoner, healer, "null");
                            }
                            System.out.println("--End of actions--");
                            char fch = decti.test(targeters, mafiachoosenplayer);
                            ob.killTarget(fch, mafiachoosenplayer, detective, Player, targeters, healer, commoner);
                            int hd = 0;
                            if (df == 1) {
                                char what = decti.test(Player, detectiveplayers);
                                if (what == 'M') {
                                    hd = 1;
                                    System.out.println(detectiveplayers + " has been voted out.");
                                    ob.mafiavoteout(mafia, detectiveplayers, Player);
                                }
                            }
                            if (hd == 0) {
                                if (ob.userplayertest(Player, userplayer) == 'a') {
                                    System.out.print("Select a person to vote out : ");
                                    int vote = in.nextInt();
                                    int ra = rand.nextInt(Player.size());
                                    String pp = Player.get(ra).getPlayer();
                                    System.out.println(pp + " has been voted out.");
                                    char ck = decti.test(Player, pp);
                                    ob.voteout(pp, ck, Player, targeters, detective, mafia, healer, commoner);

                                } else {
                                    int ra = rand.nextInt(Player.size());
                                    String pp = Player.get(ra).getPlayer();
                                    char ck = decti.test(Player, pp);
                                    System.out.println(pp + " has been voted out.");
                                    ob.voteout(pp, ck, Player, targeters, detective, mafia, healer, commoner);
                                }
                            }
                            System.out.println("--End of round" + round);
                            ++round;
                        }
                    }
                    if (fl == 0) {
                        ob.over(mafiacopy, detectivecopy, healercopy, commonercopy, fl);
                    }
                    break;

            }

        }


}
