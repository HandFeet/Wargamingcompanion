import co.uk.outlook.davidslambert.domain.setup.logic.GameService
import co.uk.outlook.davidslambert.domain.setup.models.GameDomain
import org.junit.Test
import org.junit.Assert.*
import java.util.*

class GameServiceTest {

    private val setUpService = GameService()

    @Test
    fun testValidateNoName() {
        val gameDomain = GameDomain("", false, Date(), 2)
        val validationDomain = setUpService.validate(gameDomain)
        assertFalse(validationDomain.isValid)
        assertEquals(GameService.NO_NAME_ERROR, validationDomain.errorMessage)
    }

    @Test
    fun testValidateNotEnoughPlayersZeroPlayers() {
        val gameDomain = GameDomain("NAME", false, Date(), 0)
        val validationDomain = setUpService.validate(gameDomain)
        assertFalse(validationDomain.isValid)
        assertEquals(GameService.NOT_ENOUGH_PLAYERS_ERROR, validationDomain.errorMessage)
    }

    @Test
    fun testValidateNotEnoughPlayersOnePlayers() {
        val gameDomain = GameDomain("NAME", false, Date(), 1)
        val validationDomain = setUpService.validate(gameDomain)
        assertFalse(validationDomain.isValid)
        assertEquals(GameService.NOT_ENOUGH_PLAYERS_ERROR, validationDomain.errorMessage)
    }

    @Test
    fun testValidationIsValid() {
        val gameDomain = GameDomain("NAME", false, Date(), 2)
        val validationDomain = setUpService.validate(gameDomain)
        assertTrue(validationDomain.isValid)
        assertEquals(GameService.NO_ERROR, validationDomain.errorMessage)
    }

}