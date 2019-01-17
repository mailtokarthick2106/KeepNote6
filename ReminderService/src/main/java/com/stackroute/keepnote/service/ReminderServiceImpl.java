package com.stackroute.keepnote.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.keepnote.exception.ReminderNotCreatedException;
import com.stackroute.keepnote.exception.ReminderNotFoundException;
import com.stackroute.keepnote.model.Reminder;
import com.stackroute.keepnote.repository.ReminderRepository;

/*
* Service classes are used here to implement additional business logic/validation 
* This class has to be annotated with @Service annotation.
* @Service - It is a specialization of the component annotation. It doesn't currently 
* provide any additional behavior over the @Component annotation, but it's a good idea 
* to use @Service over @Component in service-layer classes because it specifies intent 
* better. Additionally, tool support and additional behavior might rely on it in the 
* future.
* */

@Service
public class ReminderServiceImpl implements ReminderService {

	/*
	 * Autowiring should be implemented for the ReminderRepository. (Use
	 * Constructor-based autowiring) Please note that we should not create any
	 * object using the new keyword.
	 */
	@Autowired
	private ReminderRepository reminderRepository;

	/*
	 * This method should be used to save a new reminder.Call the corresponding
	 * method of Respository interface.
	 */
	public Reminder createReminder(Reminder reminder) throws ReminderNotCreatedException {

		Reminder currentReminder = this.reminderRepository.save(reminder);
		if (currentReminder != null) {
			return currentReminder;
		} else {
			throw new ReminderNotCreatedException("Reminder was not created");
		}
	}

	/*
	 * This method should be used to delete an existing reminder.Call the
	 * corresponding method of Respository interface.
	 */
	public boolean deleteReminder(String reminderId) throws ReminderNotFoundException {
		Reminder currentReminder = this.reminderRepository.findById(reminderId).get();
		if (currentReminder != null) {
			try {
				this.reminderRepository.delete(currentReminder);
				return true;
			} catch (Exception e) {
				throw e;
			}
		} else {
			throw new ReminderNotFoundException("reminder was not found");
		}
	}

	/*
	 * This method should be used to update a existing reminder.Call the
	 * corresponding method of Respository interface.
	 */
	public Reminder updateReminder(Reminder reminder, String reminderId) throws ReminderNotFoundException {

		Reminder currentReminder = this.reminderRepository.findById(reminderId).get();
		if (currentReminder != null) {
			try {
				return this.reminderRepository.save(currentReminder);
			} catch (Exception e) {
				throw e;
			}
		} else {
			throw new ReminderNotFoundException("reminder was not found");
		}
	}

	/*
	 * This method should be used to get a reminder by reminderId.Call the
	 * corresponding method of Respository interface.
	 */
	public Reminder getReminderById(String reminderId) throws ReminderNotFoundException {

		Optional<Reminder> result = this.reminderRepository.findById(reminderId);
		 return result.orElseThrow(() -> new ReminderNotFoundException(reminderId));
	}

	/*
	 * This method should be used to get all reminders. Call the corresponding
	 * method of Respository interface.
	 */

	public List<Reminder> getAllReminders() {

		return this.reminderRepository.findAll();
	}

}
