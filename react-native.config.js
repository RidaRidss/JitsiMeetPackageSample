module.exports = {
	project: {
		ios: {},
		android: {}, // grouped into "project"
	  },
	  dependencies: {
		'react-native-keyboard-input': {
			platforms: {
				android: null
			}
		},
		'@nozbe/watermelondb': {
			platforms: {
				android: null,
				ios: null
			}
		}
	}
};