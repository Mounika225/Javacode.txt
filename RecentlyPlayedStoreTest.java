package Maven_TestNg.Maven_TestNg;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.assertEquals;

public class RecentlyPlayedStoreTest {
    private RecentlyPlayedStore store;
    private User user1;
    private User user2;
    private Song song1;
    private Song song2;
    private Song song3;

    @BeforeMethod
    public void setUp() {
        store = new RecentlyPlayedStore(3);
        user1 = new User(1, "User1");
        user2 = new User(2, "User2");
        song1 = new Song(101, "Song1", "Artist1");
        song2 = new Song(102, "Song2", "Artist2");
        song3 = new Song(103, "Song3", "Artist3");
    }

    @Test
    public void testAddPlayedSong() {
        store.addPlayedSong(user1, song1);
        store.addPlayedSong(user1, song2);
        store.addPlayedSong(user1, song3);

        store.addPlayedSong(user2, song2);
        store.addPlayedSong(user2, song3);

        List<Song> user1Songs = store.getRecentlyPlayedSongs(user1);
        List<Song> user2Songs = store.getRecentlyPlayedSongs(user2);

        assertEquals(user1Songs.size(), 3);
        assertEquals(user2Songs.size(), 2);
    }

    @Test
    public void testGetRecentlyPlayedSongs() {
        store.addPlayedSong(user1, song1);
        store.addPlayedSong(user1, song2);
        store.addPlayedSong(user1, song3);

        List<Song> user1Songs = store.getRecentlyPlayedSongs(user1);
        List<Song> user2Songs = store.getRecentlyPlayedSongs(user2);

        assertEquals(user1Songs.size(), 3);
        assertEquals(user1Songs.get(0), song1);
        assertEquals(user1Songs.get(1), song2);
        assertEquals(user1Songs.get(2), song3);

        assertEquals(user2Songs.size(), 0);
    }
}
