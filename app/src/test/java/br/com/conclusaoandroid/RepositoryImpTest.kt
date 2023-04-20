package br.com.conclusaoandroid

import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.conclusaoandroid.data.RepositoryImp
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@RunWith(AndroidJUnit4::class)
class RepositoryImpTest {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var repositoryImp: RepositoryImp

    @Before
    fun setUp() {
        firebaseAuth = mock(FirebaseAuth::class.java)
        repositoryImp = RepositoryImp()
    }

    @Test
    fun testFirebaseLogin() = runBlocking {
        val email = "email@test.com"
        val password = "password"

        repositoryImp.firebaseLogin().signInWithEmailAndPassword(email, password)

        verify(firebaseAuth).signInWithEmailAndPassword(email, password)
    }

}
