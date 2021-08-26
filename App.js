/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React from 'react';

import {
  SafeAreaView,
  StyleSheet,
  ScrollView,
  View,
  Text,
  StatusBar,
  TouchableOpacity,
  NativeModules
} from 'react-native';

import {
  Colors,
} from 'react-native/Libraries/NewAppScreen';
import AsyncStorage from '@react-native-community/async-storage';


class App extends React.Component {
constructor(props) {
  super(props);
}

async componentDidMount() {
		try {
      let id = 2312;
			 AsyncStorage.setItem('workspaceId', id.toString());
		} catch (error) {

		}
}
  render(){
    // const {joined} = this.state;
  return (
    <>
      <StatusBar barStyle="dark-content" />
      <SafeAreaView>
        <ScrollView
          contentInsetAdjustmentBehavior="automatic"
          style={styles.scrollView}>
          <View style={styles.body}>
          <Text style={styles.sectionDescription}>
                    "Simple React Native App (v-0.62)"
             </Text>
                <TouchableOpacity
                  onPress={() => {
                    // this.setState({joined : true});
                    NativeModules.ActivityStarter.navigateToExample('https://meet.jit.si')
                  }}
                  
                >
                  <Text style={styles.sectionDescription}>
                 Join Meeting
             </Text>
                </TouchableOpacity>
          </View>
        </ScrollView>
      </SafeAreaView>
    </>
  );
}
};

const styles = StyleSheet.create({
  scrollView: {
    backgroundColor: Colors.lighter,
  },
  body: {
    backgroundColor: Colors.white,
    height: 600
  },
  sectionDescription: {
    marginTop: 30,
    alignSelf: 'center',
    fontSize: 22,
    fontWeight: 'bold',
    color: Colors.dark,
  }
});

export default App;
