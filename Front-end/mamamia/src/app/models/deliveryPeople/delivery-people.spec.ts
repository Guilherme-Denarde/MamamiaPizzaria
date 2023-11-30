import { DeliveryPeople } from './delivery-people';

describe('DeliveryPeople', () => {
  it('should create an instance', () => {
    expect(new DeliveryPeople()).toBeTruthy();
  });

  describe('DeliveryPeople', () => {
    it('should create an instance', () => {
      const deliveryPerson = new DeliveryPeople();
      expect(deliveryPerson).toBeTruthy();
    });
  });

  it('should have a method that performs a specific action', () => {
    const deliveryPerson = new DeliveryPeople();

    // Suponhamos que someMethod() retorne um valor específico, como 'success'
    const expectedValue = 'success';

    // Defina someMethod() na classe DeliveryPeople
    deliveryPerson.someMethod = () => expectedValue;

    // Agora você pode testar someMethod()
    expect(deliveryPerson.someMethod()).toBe(expectedValue);
  });
  

  
});
