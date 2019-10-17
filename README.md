ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
Person p = applicationContext.getBean("p1", Person.class);

#applicationContext.getBean("p1", Person.class);
	#调用getBean()方法
		#org.springframework.context.support.AbstractApplicationContext
			@Override
			public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
				assertBeanFactoryActive();
				return getBeanFactory().getBean(name, requiredType);
			}
			
			org.springframework.beans.factory.support.AbstractBeanFactory
			public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory 
			
				@Override
				public Object getBean(String name, Object... args) throws BeansException {
					return doGetBean(name, null, args, false);
				}
				
				doGetBean()方法
					#Object sharedInstance = getSingleton(beanName);//单例模式
						#org.springframework.beans.factory.support.DefaultSingletonBeanRegistry
						#protected Object getSingleton(String beanName, boolean allowEarlyReference)
						
						public Object getSingleton(String beanName) {
							return getSingleton(beanName, true);
						}
						
						#--》
						protected Object getSingleton(String beanName, boolean allowEarlyReference) {
							#private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);
							Object singletonObject = this.singletonObjects.get(beanName);
							if (singletonObject == null && isSingletonCurrentlyInCreation(beanName)) {
								synchronized (this.singletonObjects) {
									singletonObject = this.earlySingletonObjects.get(beanName);
									if (singletonObject == null && allowEarlyReference) {
										ObjectFactory<?> singletonFactory = this.singletonFactories.get(beanName);
										if (singletonFactory != null) {
											singletonObject = singletonFactory.getObject();
											this.earlySingletonObjects.put(beanName, singletonObject);
											this.singletonFactories.remove(beanName);
										}
									}
								}
							}
							return singletonObject;
						}
					
					
					--代码
					if (sharedInstance != null && args == null) {
						if (logger.isTraceEnabled()) {
							if (isSingletonCurrentlyInCreation(beanName)) {
								logger.trace("Returning eagerly cached instance of singleton bean '" + beanName +
										"' that is not fully initialized yet - a consequence of a circular reference");
							}
							else {
								logger.trace("Returning cached instance of singleton bean '" + beanName + "'");
							}
						}
						#这一行ctrl可以进入xml配置文件里
						bean = getObjectForBeanInstance(sharedInstance, name, beanName, null);
					}
					
					protected Object getObjectForBeanInstance(Object beanInstance, String name, String beanName,
							 @Nullable RootBeanDefinition mbd) {
			
					// Don't let calling code try to dereference the factory if the bean isn't a factory.
					if (BeanFactoryUtils.isFactoryDereference(name)) {
						if (beanInstance instanceof NullBean) {
							return beanInstance;
						}
						if (!(beanInstance instanceof FactoryBean)) {
							throw new BeanIsNotAFactoryException(beanName, beanInstance.getClass());
						}
						if (mbd != null) {
							mbd.isFactoryBean = true;
						}
						return beanInstance;
					}
				
				
				protected Object getObjectForBeanInstance(--》if (BeanFactoryUtils.isFactoryDereference(name)) {
			
			
			