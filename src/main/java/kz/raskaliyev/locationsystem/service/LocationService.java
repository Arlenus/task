// package kz.raskaliyev.locationsystem.service;

// import kz.raskaliyev.locationsystem.model.entity.Location;
// import kz.raskaliyev.locationsystem.model.entity.User;
// import org.springframework.stereotype.Service;

// import kz.raskaliyev.locationsystem.repository.LocationRepository;
// import kz.raskaliyev.locationsystem.repository.UserRepository;

// import java.util.ArrayList;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Set;

// import static kz.raskaliyev.locationsystem.model.enums.AccessLevel;

// @Service
// public class LocationService {
//     private final LocationRepository locationRepository;
//     private final UserRepository userRepository;

//     public LocationService(LocationRepository locationRepository, UserRepository userRepository) {
//         this.locationRepository = locationRepository;
//         this.userRepository = userRepository;
//     }

//     public Location createLocation(String locationName, String address, User owner) {
//         Location location = new Location();
//         location.setName(locationName);
//         location.setAddress(address);
//         location.setOwner(owner);
//         location.setFriends(new HashSet<>());
//         location.setReadOnlyFriends(new HashSet<>());
//         return locationRepository.save(location);
//     }

//     public Location shareLocationWithUser(Location location, User friend, AccessLevel accessLevel) {
//         if (location.getOwner().equals(friend)) {
//             throw new IllegalArgumentException("Cannot share location with owner.");
//         }
//         Set<User> friends = location.getFriends();
//         Set<User> readOnlyFriends = location.getReadOnlyFriends();
//         switch (accessLevel) {
//             case ADMIN:
//                 friends.add(friend);
//                 readOnlyFriends.remove(friend);
//                 break;
//             case READ_ONLY:
//                 friends.remove(friend);
//                 readOnlyFriends.add(friend);
//                 break;
//         }
//         location.setFriends(friends);
//         location.setReadOnlyFriends(readOnlyFriends);
//         return locationRepository.save(location);
//     }

//     public Location removeFriend(Location location, User friend) {
//         Set<User> friends = location.getFriends();
//         friends.remove(friend);
//         location.setFriends(friends);
//         return locationRepository.save(location);
//     }

//     public Location removeReadOnlyFriend(Location location, User readOnlyFriend) {
//         Set<User> readOnlyFriends = location.getReadOnlyFriends();
//         readOnlyFriends.remove(readOnlyFriend);
//         location.setReadOnlyFriends(readOnlyFriends);
//         return locationRepository.save(location);
//     }

//     public Location addFriend(Location location, User friend) {
//         Set<User> friends = location.getFriends();
//         friends.add(friend);
//         location.setFriends(friends);
//         return locationRepository.save(location);
//     }

//     public List<User> getAllFriends(Location location) {
//         Set<User> friends = location.getFriends();
//         Set<User> readOnlyFriends = location.getReadOnlyFriends();
//         List<User> allFriends = new ArrayList<>();
//         allFriends.addAll(friends);
//         allFriends.addAll(readOnlyFriends);
//         return allFriends;
//     }

//     public List<Location> getAllLocationsForUser(User user) {
//         List<Location> ownLocations = locationRepository.findByOwner(user);
//         List<Location> sharedLocations = locationRepository.findByFriendsContaining(user);
//         List<Location> readOnlyLocations = locationRepository.findByReadOnlyFriendsContaining(user);
//         List<Location> allLocations = new ArrayList<>();
//         allLocations.addAll(ownLocations);
//         allLocations.addAll(sharedLocations);
//         allLocations.addAll(readOnlyLocations);
//         return allLocations;
//     }

// }
