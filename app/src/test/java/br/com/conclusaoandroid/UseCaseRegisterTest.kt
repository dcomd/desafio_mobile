package br.com.conclusaoandroid

import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.conclusaoandroid.data.RepositoryImp
import br.com.conclusaoandroid.domain.model.UseCaseRegister
import com.google.android.gms.tasks.Tasks
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

@RunWith(AndroidJUnit4::class)
class UseCaseRegisterTest {
    private lateinit var repositoryImp: RepositoryImp
    private lateinit var useCaseRegister: UseCaseRegister
    private lateinit var firebaseAuth: FirebaseAuth

    @Before
    fun setUp() {
        repositoryImp = mock(RepositoryImp::class.java)
        useCaseRegister = UseCaseRegister(repositoryImp)
        firebaseAuth = FirebaseAuth.getInstance()
    }

    @Test
    fun testRegisterFirebase() = runBlocking {
        val email = "email@test.com"
        val password = "password"

        val mockAuthResult = mock(AuthResult::class.java)
        `when`(repositoryImp.firebaseLogin().createUserWithEmailAndPassword(email, password)).thenReturn(
            Tasks.forResult(mockAuthResult))

        val result = useCaseRegister.registerFirebase(email, password)

        assertEquals(true, result)
    }

}
