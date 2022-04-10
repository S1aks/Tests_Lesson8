package com.example.lesson_8.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.lesson_8.domain.Repository
import com.example.lesson_8.domain.entities.GithubUser
import junit.framework.TestCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.test.*
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations


@LargeTest
@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
class MainViewModelTest : TestCase() {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()
    private var testScope = TestScope(testDispatcher)

    private lateinit var mainViewModel: MainViewModel

    @Mock
    private lateinit var repository: Repository

    @Before
    override fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        mainViewModel = MainViewModel(repository)
    }

    @Test
    fun coroutines_TestReturnValueIsNotNull() = testScope.runTest {
        val observer = Observer<List<GithubUser>> {}
        val liveData = mainViewModel.openLiveData
        `when`(repository.getUsers()).thenReturn(
            listOf(GithubUser("login", 0, "", ""))
        )
        try {
            liveData.observeForever(observer)
            mainViewModel.getData()
            Assert.assertNotNull(liveData.value)
        } finally {
            liveData.removeObserver(observer)
        }
    }

    @After
    override fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cancelChildren()
    }
}