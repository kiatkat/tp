package profplan.testutil;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import profplan.logic.commands.EditCommand.EditTaskDescriptor;
import profplan.model.tag.Tag;
import profplan.model.task.Address;
import profplan.model.task.Email;
import profplan.model.task.Link;
import profplan.model.task.Name;
import profplan.model.task.Phone;
import profplan.model.task.Task;

/**
 * A utility class to help with building EditTaskDescriptor objects.
 */
public class EditTaskDescriptorBuilder {

    private EditTaskDescriptor descriptor;

    public EditTaskDescriptorBuilder() {
        descriptor = new EditTaskDescriptor();
    }

    public EditTaskDescriptorBuilder(EditTaskDescriptor descriptor) {
        this.descriptor = new EditTaskDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditTaskDescriptor} with fields containing {@code task}'s details
     */
    public EditTaskDescriptorBuilder(Task task) {
        descriptor = new EditTaskDescriptor();
        descriptor.setName(task.getName());
        descriptor.setPhone(task.getPhone());
        descriptor.setEmail(task.getEmail());
        descriptor.setAddress(task.getAddress());
        descriptor.setTags(task.getTags());
        descriptor.setLink(task.getLink());
    }

    /**
     * Sets the {@code Name} of the {@code EditTaskDescriptor} that we are building.
     */
    public EditTaskDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code EditTaskDescriptor} that we are building.
     */
    public EditTaskDescriptorBuilder withPhone(String phone) {
        descriptor.setPhone(new Phone(phone));
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code EditTaskDescriptor} that we are building.
     */
    public EditTaskDescriptorBuilder withEmail(String email) {
        descriptor.setEmail(new Email(email));
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code EditTaskDescriptor} that we are building.
     */
    public EditTaskDescriptorBuilder withAddress(String address) {
        descriptor.setAddress(new Address(address));
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code EditTaskDescriptor}
     * that we are building.
     */
    public EditTaskDescriptorBuilder withTags(String... tags) {
        Set<Tag> tagSet = Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTags(tagSet);
        return this;
    }

    /**
    * Sets the {@code Link} of the {@code EditTaskDescriptor} that we are building.
    */
    public EditTaskDescriptorBuilder withLink(String link) {
        descriptor.setLink(new Link(link));
        return this;
    }

    public EditTaskDescriptor build() {
        return descriptor;
    }
}
