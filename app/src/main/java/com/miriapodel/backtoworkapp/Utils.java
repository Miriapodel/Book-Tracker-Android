package com.miriapodel.backtoworkapp;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.widget.WithHint;

import com.bumptech.glide.util.Util;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {

    private static Utils instance;

    private SharedPreferences sharedPreferences;

    private static final String ALL_BOOKS_KEY="all_books";
    private static final String CURRENTLY_READING_KEY="currently_reading";
    private static final String ALREADY_READ_KEY="already_read";
    private static final String WISHLIST="wishlist";
    private static final String FAVORITES="favorites";

    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> alreadyReadBooks;
    private static ArrayList<Book> wishlistBooks;
    private static ArrayList<Book> favoritesBooks;

    public Utils(Context context)
    {
        sharedPreferences = context.getSharedPreferences("alternate_db", Context.MODE_PRIVATE);

        if(getAllBooks() == null)
        {
            addInitialData();
        }

        Gson gson = new Gson();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(getCurrentlyReadingBooks() == null)
        {
            editor.putString(CURRENTLY_READING_KEY, gson.toJson(new ArrayList<Book>()));

            editor.commit();

        }

        if(getAlreadyReadBooks() == null)
        {
            editor.putString(ALREADY_READ_KEY ,gson.toJson(new ArrayList<Book>()));

            editor.commit();
        }

        if(getWishlistBooks() == null)
        {
            editor.putString(WISHLIST, gson.toJson(new ArrayList<Book>()));

            editor.commit();
        }

        if(favoritesBooks == null)
        {
            editor.putString(FAVORITES, gson.toJson(new ArrayList<Book>()));

            editor.commit();
        }
    }

    private void addInitialData()
    {
        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book(1, 460,"https://www.edituracartex.ro/wp-content/uploads/2019/06/Enigma-Otiliei-George-Calinescu.jpeg", "Enigma Otiliei", "George Calinescu", "Romanul, alcatuit din 20 de capitole, este construit pe mai multe planuri narative", "Felix Sima, un tânăr de 18 ani, vine în București la unchiul său Costache Giurgiuveanu pentru a urma Facultatea de medicină. Ajuns la adresa indicată, Otilia, fata vitregă a bătrânului, îl invită în casă, unde îi cunoaște pe membrii familiei: mătușa Aglae, unchiul Simion și copiii acestora Titi, Aurica, Olimpia, ginerele Stănică Rațiu precum și prietenul de familie Leonida Pascalopol. A doua zi, Otilia îi arată locuința, el remarcă felul jucăuș al fetei și este surprins când găsește o scrisoare adresată acesteia, pe numele Otilia Mărculescu. Fata este râvnită de Leonida Pascalopol și invidiată de toți membrii familiei Tulea. Felix, curios de enigma numelui Mărculescu, descoperă soarta Otiliei care nu este cu mult diferită de a sa. Fata a rămas orfană de mică și este crescută de tatăl său vitreg, moș Costache. Pascalopol a cunoscut-o pe mama Otiliei și de atunci i-a ajutat foarte mult, Otilia purtându-i o stimă deosebită. Rugat de Aglae, Felix îl meditează pe Titi care a rămas corigent, și în aceste împrejurări sora sa Aurica se atașează de tânăr. El, însă, se simte tot mai atras de Otilia pe care o admiră și cu care petrece din ce în ce mai mult timp. Vede însă în Pascalopol un rival. La începutul lunii august, Olimpia, cel mai mare copil al Aglaei, își face apariția acasă împreună cu Stănică, concubinul ei, cu care are un copil. Simion nu-și recunoaște fiica și refuză să-i dea o casă de locuit și zestrea sa. Stănică, prin minciuni și scrisori adresate domnului Pascalopol cum că se împușcă, reușește să strângă ceva bani de la toți și să-l înduplece pe Simion cu motivarea că mai are câteva luni de trăit, să-i dea zestrea Olimpiei. La invitația lui Pascalopol, Felix și Otilia se duc la moșia acestuia, unde tinerii profită de timpul petrecut împreună, iar după două săptămâni revin acasă. Între timp, fiul Olimpiei și al lui Stănică, Aurel Rațiu, moare, iar tatăl, înduioșat, îi publică în ziar decesul, amintind toate rudele, în speranța de a obține cât mai mult sprijin financiar. Stănică este interesat de averea lui moș Costache și în acest scop îl aduce pe un oarecare doctor Vasiliade pentru a-i pune diagnosticul că este bolnav. Singurul care descoperă planul este Pascalopol, care îl avertizează pe bătrân.\n" +
                "\n" +
                "Între Felix și Otilia se clădește o relație profundă de prietenie și atașament. Felix îi mărturisește iubirea, iar Otilia pare și ea înduioșată, însă privește totul în mod copilăresc. Grija sa pentru Felix pare mai mult a unei surori. Rușinat, Felix își pune pe hârtie toate sentimentele sale, trimițându-i Otiliei scrisoarea, însă ea nu-i dă nici un răspuns. Într-un moment de gelozie, Felix o roagă pe Otilia să nu se mai întâlnească cu Pascalopol, însă tot el, invitat de acesta la el acasă, își dă seama de greșeala făcută față de Otilia. În casă discuțiile despre adopția Otiliei de către moș Costache declanșează un nou val cu scandaluri din partea Aglaei. În cele din urmă, fata îi cere lui moș Costache să nu întocmească formalitățile de adopție și pleacă cu Pascalopol la Paris, spre surprinderea lui Felix, care rămâne dezamăgit. El se refugiază în brațele unei curtezane, Georgeta. Felix are ocazia să-l cunoască pe Weissmann, un coleg de facultate care-i trezește pasiuni nebănuite pentru poezie. Discuțiile avute cu acesta îi dezvăluie situația materială dificilă a studentului, dar și spiritul practic al acestuia, care face injecții și consultă diferite persoane pentru a-și întreține frații și surorile. Cina la restaurantul domnului Iorgu în cinstea aniversării fiicei sale minore îi reunesc la aceeași masă pe Georgeta cu generalul, pe Stănică, Olimpia, Aglae, Titi, Felix și moș Costache. Aglae pare foarte interesată de viitorul fiicei celor două gazde, în speranța că o va căsători cu Titi, în timp ce Felix se simte din ce în ce mai jignit de purtările Georgetei. La început, după o ușoară criză, familia Tulea ignoră purtările lui Simion, care începuse să aiureze, însă văzând că situația devine insuportabilă, Aglae ajutată de Stănică și de Weissmann îl duc la un sanatoriu. Titi se află în centrul atenției pentru Aglae care urmărește să-l însoare cât mai bine spre dezamăgirea Auricii și a Olimpiei. O nepoată a sa de 16 ani pe nume Lili își manifestă dorința de a se căsători, iar Stănică îl recomandă tatălui acesteia pe Felix Sima, în special pentru că dorea a aduce în rândurile familiei sale și oameni culți. Felix visează că Otilia cântă la pian, însă spre surprinderea sa totul pare a fi realitate. Revăzându-se, cei doi povestesc îndelung, în timp ce Felix se simte tot mai atras de Otilia și de schimbarea acesteia. Moș Costache are planurile sale cu cei doi tineri, începând să adune materiale de construcții pentru o casă unde cei doi, Felix și Otilia aveau să stea după moartea sa. Stănică îi face cunoștință lui Felix cu Lili, spre supărarea lui Titi, care este atras de fată și nu înțelege de ce toate sunt atrase de băiatul doctorului Sima. Din cauza unei ușoare insolații și a efortului, moș Costache are un atac, în urma căruia toată familia Tulea își petrece două zile în casa bătrânului ignorând boala acestuia. Pascalopol aduce un doctor avizat, profesor la universitate, care recomandă multă liniște și odihnă bolnavului.\n" +
                "\n" +
                "Moș Costache se însănătoșește și îi alungă din casă pe toți cei din familia Tulea fiind de acord cu propunerea lui Pascalopol de a deschide un cont în bancă pe numele Otiliei cu suma de 300.000 lei, însă nu-i dă banii, încrezându-se în sănătatea sa. Moșierul deschide contul și depune în el 100.000 lei pe numele Otiliei. După infarct, moș Costache devine din ce în ce mai speriat de moarte, la aceasta contribuind și Stănică care îi povestea tot felul de nenorociri. Consultă diferiți doctori, urmează chiar un tratament cheltuind bani pe medicamente și invită preoții să-i sfințească casa. Vinde apoi anumite imobile și aduce în casă o menajeră pe nume Paulina, dar care nu stă mult pentru că bătrânul îi descoperă interesul față de averea sa. Aurica se spovedește preotului Țuică, mărturisindu-i dorința de a se căsători cu un evreu și anume cu Weissemann, iar Stănică o îndeamnă pe Otilia să-l convingă pe Felix să se căsătorească cu Lili. Moș Costache îi dăruiește lui Pascalopol 100.000 lei pentru Otilia. Stănică, după îndelungi căutări află locul unde sunt ascunși banii și-l jefuiește. Moș Costache este surprins de atac și, în urma efortului, moare. Stănică divorțează de Olimpia și se căsătorește cu Georgeta, iar apoi intră în politică. Otilia se căsătorește cu Pascalopol și pleacă împreună la Paris. Felix, cu ocazia războiului, devine doctor, apoi profesor universitar și se căsătorește bine, intrând în cercuri înalte. Se întâlnește întâmplător cu Pascalopol în tren și află că acesta a divorțat de Otilia, fiind acum căsătorită cu un om bogat din Buenos Aires. Fotografia arătată nu mai aduce nimic din ceea ce era odinioară Otilia. Amintirile acelei idile se năruiesc în cuvintele lui moș Costache: „Aici nu stă nimeni”."));
        books.add(new Book(2, 525,"https://s1.cel.ro/images/mari/ion---liviu-rebreanu-agora.jpg", "Ion", "Liviu Rebreanu", "Liviu Rebreanu creează în opera sa Ion o galerie bogată de personaje, dominantă fiind imaginea lui Ion", "Romanul începe cu descrierea drumului care duce către satul Pripas, la care se ajunge prin „șoseaua ce vine de la Cârlibaba, întovărășind Someșul” până la Cluj, din care se desprinde „un drum alb mai sus de Armadia” și după ce lasă Jidovița în urmă, „drumul urcă întâi anevoie până ce-și face loc printre dealurile strâmtorate (...), apoi cotește brusc pe sub Râpile Dracului, ca să dea buzna în Pripasul pitit într-o scrântitură de coline”. La intrarea în sat, „te întâmpină (...) o cruce strâmbă pe care e răstignit un Hristos cu fața spălată de ploi și cu o cununiță de flori veștede agățată de picioare”. Imaginea este reluată simbolic nu numai în finalul romanului, ci și în desfășurarea acțiunii, în scena licitației la care se vindeau mobilele învățătorului, sugerând destinul tragic al lui Ion și al Anei, precum și viața tensionată și necazurile celorlalte personaje: Titu, Zaharia Herdelea, Ioan Belciug, Vasile Baciu, George Bulbuc etc.\n" +
                "\n" +
                "Acțiunea romanului începe într-o zi de duminică, în care toți locuitorii satului Pripas se află adunați la hora tradițională, în curtea Todosiei, văduva lui Maxim Oprea. Nu lipsesc nici fruntașii satului, familia învățătorului Herdelea, preotul Belciug, fostul învățător - tolstoianul Simion Butunoiu -, și „bocotanii” care cinstesc cu prezența lor sărbătoarea. Hora este o pagină etnografică memorabilă prin jocul tradițional, vigoarea flăcăilor și candoarea fetelor, prin lăuta țiganilor care compun imaginea unui ritm impetuos: „De tropotele jucătorilor se hurducă pământul. Zecile de perechi bat someșana cu atâta pasiune, că potcoavele flăcăilor scapără scântei, poalele fetelor se bolbocesc, iar colbul de pe jos se învâltorește, se așază în straturi groase pe fețele brăzdate de sudoare, luminate de oboseală și de mulțumire”.\n" +
                "\n" +
                "Lui Ion îi place Florica, dar Ana are pământ, așa că el îi face curte acesteia, spre disperarea lui Vasile Baciu, tatăl Anei, care se ceartă cu Ion și-l face de râsul satului, spunându-i „sărăntoc”. Alexandru Glanetașu, tatăl lui Ion, a risipit zestrea Zenobiei, care avusese avere când se măritase cu el. Vasile Baciu, om vrednic al satului, se însurase tot pentru avere cu mama Anei, dar fiind harnic sporise averea și se gândea să-i asigure fetei zestre atunci când se va mărita.\n" +
                "\n" +
                "Ion, flăcău harnic și mândru, dar sărac o necinstește pe Ana și îl obligă astfel pe Vasile Baciu să i-o dea de nevastă împreună cu o parte din pământuri. Obținând avere, Ion dobândește situație socială, demnitate umană și satisfacerea propriului orgoliu.\n" +
                "\n" +
                "În celălalt plan, familia învățătorului Herdelea are necazurile sale. Herdelea își zidise casa pe lotul ce aparținea bisericii, cu învoirea preotului Belciug. Relațiile învățătorului cu preotul se degradează cu timpul, de aceea Herdelea se teme că ar putea pierde toată agoniseala și i-ar rămâne familia pe drumuri. Preotul Belciug, rămas văduv încă din primul an, are o personalitate puternică, este cel mai respectat și temut om din sat, având o autoritate totală asupra întregii colectivități.\n" +
                "\n" +
                "În sat, domină mentalitatea că oamenii sunt respectați dacă au oarecare agoniseală, fapt ce face ca relațiile sociale să fie tensionate între „sărăntoci” și „bocotani”, între chibzuința rosturilor și nechibzuința patimilor, ceea ce face să se dea în permanență o luptă aprigă pentru existență.\n" +
                "\n" +
                "Destinele personajelor sunt determinate de această mentalitate, de faptul că familiile nu se întemeiază pe sentimente, ci pe interese economice: „În societatea țărănească, femeia reprezintă două brațe de lucru, o zestre și o producătoare de copii. Odată criza erotică trecută, ea încetează de a mai însemna ceva pentru feminitate. Soarta Anei e mai rea, dar deosebită cu mult de a oricărei femei, nu” (G. Călinescu). Bătută de tată și de soț, Ana, rămasă fără sprijin moral, dezorientată și respinsă de toți, se spânzură. Florica, părăsită de Ion, se căsătorește cu George și se bucură de norocul pe care îl are, deși îl iubea tot pe Ion."));

        Gson gson = new Gson();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(ALL_BOOKS_KEY, gson.toJson(books));
        editor.commit();

    }

    public ArrayList<Book> getAllBooks() {

        ArrayList<Book> books;

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        books = gson.fromJson(sharedPreferences.getString(ALL_BOOKS_KEY, null), type);

        return books;

    }

    public ArrayList<Book> getCurrentlyReadingBooks() {

        ArrayList<Book> books;

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        books = gson.fromJson(sharedPreferences.getString(CURRENTLY_READING_KEY, null), type);

        return books;

    }

    public ArrayList<Book> getAlreadyReadBooks() {

        ArrayList<Book> books;

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        books = gson.fromJson(sharedPreferences.getString(ALREADY_READ_KEY, null), type);

        return books;

    }

    public ArrayList<Book> getWishlistBooks() {

        ArrayList<Book> books;

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        books = gson.fromJson(sharedPreferences.getString(WISHLIST, null), type);

        return books;
    }

    public ArrayList<Book> getFavoritesBooks() {

        ArrayList<Book> books;

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        books = gson.fromJson(sharedPreferences.getString(FAVORITES, null), type);

        return books;

    }

    public static Utils getInstance(Context context)
    {

        if(instance != null)
        {
            return instance;
        }
        else
        {
            instance = new Utils(context);

            return instance;
        }

    }

    public Book getBookById(int id)
    {
        ArrayList<Book> books = getAllBooks();

        for(Book b : books)
            if(id == b.getId())
                return b;

            return null;
    }

    public boolean addToCurrentlyReading(Book book)
    {
       ArrayList<Book> books = getCurrentlyReadingBooks();

       Gson gson = new Gson();
       SharedPreferences.Editor editor = sharedPreferences.edit();

       if(books != null)
       {
           if(books.add(book))
           {
               editor.remove(CURRENTLY_READING_KEY);

               editor.putString(CURRENTLY_READING_KEY, gson.toJson(books));
               editor.commit();

               return true;
           }
       }

       return false;
    }

    public boolean addToAlreadyReadBooks(Book book)
    {
        ArrayList<Book> books = getAlreadyReadBooks();

        Gson gson = new Gson();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(books != null)
        {
            if(books.add(book))
            {
                editor.remove(ALREADY_READ_KEY);

                editor.putString(ALREADY_READ_KEY, gson.toJson(books));
                editor.commit();

                return true;
            }
        }

        return false;
    }

    public boolean addToWishlistBooks(Book book)
    {
        ArrayList<Book> books = getWishlistBooks();

        Gson gson = new Gson();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(books != null)
        {
            if(books.add(book))
            {
                editor.remove(WISHLIST);

                editor.putString(WISHLIST, gson.toJson(books));
                editor.commit();

                return true;
            }
        }

        return false;
    }

    public boolean addToFavoritesBooks(Book book)
    {
        ArrayList<Book> books = getFavoritesBooks();

        Gson gson = new Gson();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(books!=null)
        {
            if(books.add(book))
            {
                editor.remove(FAVORITES);

                editor.putString(FAVORITES, gson.toJson(books));
                editor.commit();

                return true;
            }
        }

        return false;
    }

    public boolean removeFromCurrentlyReading(Book book)
    {
        ArrayList<Book> books = getCurrentlyReadingBooks();

        if(books!=null) {
            for (Book b : books) {
                if(b.getId() == book.getId())
                {
                    if(books.remove(book))
                    {
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.remove(CURRENTLY_READING_KEY);
                        editor.putString(CURRENTLY_READING_KEY, gson.toJson(books));
                        editor.commit();

                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean removeFromAlreadyRead(Book book)
    {
        ArrayList<Book> books = getAlreadyReadBooks();

        if(books!=null)
        {
            for(Book b : books)
            {
                if(b.getId() == book.getId())
                {
                    if(books.remove(b))
                    {
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.remove(ALREADY_READ_KEY);
                        editor.putString(ALREADY_READ_KEY, gson.toJson(books));
                        editor.commit();

                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean removeFromWishlist(Book book)
    {
        ArrayList<Book> books = getWishlistBooks();

        if(books != null)
        {
            for(Book b : books)
            {
                if(b.getId() == book.getId())
                {
                    if(books.remove(b))
                    {
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.remove(WISHLIST);
                        editor.putString(WISHLIST, gson.toJson(books));
                        editor.commit();

                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean removeFromFavorites(Book book)
    {
        ArrayList<Book> books = getFavoritesBooks();

        if(books != null)
        {
            for(Book b : books)
            {
                if(b.getId() == book.getId())
                {
                    if(books.remove(b))
                    {
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.remove(FAVORITES);
                        editor.putString(FAVORITES, gson.toJson(books));
                        editor.commit();

                        return true;
                    }
                }
            }
        }

        return false;
    }

}
