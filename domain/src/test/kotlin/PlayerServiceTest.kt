import co.uk.outlook.davidslambert.domain.setup.logic.PlayerService
import co.uk.outlook.davidslambert.domain.setup.models.PlayerDomain
import org.junit.Assert
import org.junit.Test

class PlayerServiceTest {

    private val setUpService = PlayerService()

    @Test
    fun testValidateNoName() {
        val playerDomain = PlayerDomain("", 0, 2, 0,0)
        val validationDomain = setUpService.validate(playerDomain)
        Assert.assertFalse(validationDomain.isValid)
        Assert.assertEquals(PlayerService.NO_NAME_ERROR, validationDomain.errorMessage)
    }

    @Test
    fun testValidationIsValid() {
        val playerDomain = PlayerDomain("Im a name", 0, 2, 0,0)
        val validationDomain = setUpService.validate(playerDomain)
        Assert.assertTrue(validationDomain.isValid)
        Assert.assertEquals(PlayerService.NO_ERROR, validationDomain.errorMessage)
    }


}