package core.dailysummary.api.spec

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult
import io.kotest.extensions.spring.SpringExtension
import io.mockk.clearAllMocks
import io.mockk.mockkClass
import org.junit.platform.commons.util.ClassFilter
import org.junit.platform.commons.util.ReflectionUtils
import org.springframework.beans.factory.config.BeanFactoryPostProcessor
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.stereotype.Service

@WebMvcTest
@AutoConfigureRestDocs
@Import(MockServiceBeanFactoryPostProcessor::class)
abstract class ApiTestSpec(
    body: DescribeSpec.() -> Unit = {}
) : DescribeSpec(body) {
    override fun extensions() = listOf(SpringExtension)

    override suspend fun afterEach(testCase: TestCase, result: TestResult) {
        clearAllMocks()
    }
}

class MockServiceBeanFactoryPostProcessor : BeanFactoryPostProcessor {

    override fun postProcessBeanFactory(beanFactory: ConfigurableListableBeanFactory) {
        val classFilter = ClassFilter.of { it.isAnnotationPresent(Service::class.java) }
        ReflectionUtils.findAllClassesInPackage("core.dailysummary", classFilter).forEach {
            beanFactory.registerSingleton(it.simpleName, mockkClass(it.kotlin))
        }
    }
}